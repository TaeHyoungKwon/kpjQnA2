//class 명이 answer-write인 것의 input type이 submit이 클릭되었을 때, addAnswer함수를 실행한다.
$(".answer-write input[type=submit]").click(addAnswer);

function addAnswer(e) {
  e.preventDefault();
  console.log("click me");

  //addAnser함수는 form에서 전달된 값을 serialize()하여서,
  //key,value형태로 내보난다. -> 여기선 ex) contents=abcde
  var queryString = $(".answer-write").serialize();
  console.log("query:" + queryString);

  //class 명이 answer-write인 태그의 action부분을 가져온다.
  var url = $(".answer-write").attr("action");
  console.log(url);

  //위에서 저장한 url에 대해서, ajax 콜을 한다.
  //위의 url을 post 형식으로 data를 body에 실어서 요청했을 때, 응답 값을 json으로 받는다.
  $.ajax({
    type: "post",
    url: url,
    data: queryString,
    dataType: "json",
    error: onError,
    success: onSuccess,
  });

  function onError() {}
  function onSuccess(data, status) {
    //show.html 상에, 미리 만들어 놓은 answerTemplate을 불러온다.
    var answerTemplate = $("#answerTemplate").html();

    //불러온 answerTemplate에 format에 맞춰서, 순서대로을 넘긴다.
    var template = answerTemplate.format(
      data.writer.userId,
      data.formattedCreateDate,
      data.contents,
      data.question.id,
      data.id
    );

    //위에서 만든 template을 앞에다 붙인다.
    $(".qna-comment-slipp-articles").prepend(template);
    //textarea는 공백으로 해준다.
    $(".answer-write textarea").val("");
  }
}

//a 태그의 link-delete-article 클래스를 클릭했을 때,
//deleteAnswer 함수를 실행한다.
$("a.link-delete-article").click(deleteAnswer);

function deleteAnswer(e) {
  e.preventDefault();
  //$(this)를 따로 빼놓는다.
  var deleteBtn = $(this);

  //해당 버튼의 url을 변수로 저장한다.
  var url = $(this).attr("href");

  //ajax 요청을 보낸다.
  //typedms delete로 위에서 저장한 url로 보낸다.
  //해당 url을 호출하면서, ApiAnswerController.java의 코드를 통해 디비에서는 삭제된다.
  $.ajax({
    type: "delete",
    url: url,
    dataType: "json",
    error: function(xhr, status) {
      console.log("error");
    },
    //성공 했을 시,
    success: function(data, status) {
      //값이 유효하다면,
      if (data.valid) {
        //위 버튼에서 가장 가까운 article을 찾아서, 삭제한다.
        deleteBtn.closest("article").remove();
      } else {
        //유효하지 않다면, 에러 메세지를 보낸다.
        alert(data.errorMessage);
      }
    },
  });
}

String.prototype.format = function() {
  var args = arguments;
  return this.replace(/{(\d+)}/g, function(match, number) {
    return typeof args[number] != "undefined" ? args[number] : match;
  });
};
