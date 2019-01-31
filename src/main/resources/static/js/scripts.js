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
    console.log(data);
  }
}

// String.prototype.format = function() {
//   var args = arguments;
//   return this.replace(/{(\d+)}/g, function(match, number) {
//     return typeof args[number] != 'undefined'
//         ? args[number]
//         : match
//         ;
//   });
// };
