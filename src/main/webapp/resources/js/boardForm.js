/**
 * 
 */

var count = 1;

function setCount(c) {
	count = count + c;
}

$("#file").on("click", ".remove", function() {
	$(this).parent().remove();
	count--;
});

$("#add")
		.click(
				function() {
					if (count < 6) {
						$("#file")
								.append(
										'<div class="form-group"> <label for="file"> File :</label> <input type="file" class="form-control files" name="files"> <i class="glyphicon glyphicon-remove remove"></i> </div>');
						count++;
					} else {
						alert("파일은 최대 5개 까지입니다.")
					}

				});

// --------------------------------------------------------------------------------------------

// summernote에 이미지 올리기
$('#contents').summernote({
	height : 400,
	callbacks : {
		onImageUpload : function(files, editor) {
			var formData = new FormData();// <form></form>
			formData.append('files', files[0]); // <input type = "file" name
												// ="">
			$.ajax({
				type : "post",
				url : "../boardFile/fileInsert",
				data : formData,
				enctype : "multipart/form-data",
				cache : false,
				contentType : false,
				processData : false,
				success : function(imageName) {
					imageName = imageName.trim();
					$("#contents").summernote('editor.insertImage', imageName);

				}
			});
		}, // onImageUpload
		
		onMediaDelete:function(files){	
			
			var fileName = $(files[0]).attr("src");
			fileName = fileName.substring(fileName.lastIndexOf("/")+1);
			console.log(fileName);
	
			$.ajax({
				type:"post",
				url:"../boardFile/summerDelete",
				data:{
					fileName:fileName
				},
				success:function(data){
					console.log(data)
				}
				
			});
		}//OnMediaDelete
		
		
		
	}//callBack
});

// --------------------------------------------------------------------------------------------

$("#btn").click(function() {

	// title, contents 데이터 유무 검증
	var title = $("#title").val();

	var contents = $("#contents").summernote('code');
	console.log($("#contents").summernote('isEmpty'));

	var ch3 = true;

	$(".files").each(function() {
		if ($(this).val() == "") {
			ch3 = false;
		}
	});

	var ch1 = title != "";
	var ch2 = $("#contents").summernote('isEmpty');

	if (ch1 && !ch2 && ch3) {
		// form 전송(submit event 강제 발생)
		// $("#con").val(contents);// contents Server null일때
		$("#frm").submit();

	} else {
		// submit event 종료
		alert("필수 요소는 다 입력하세요");
		/*
		 * console.log(title==''); console.log(contents=="");
		 * console.log(title.length); console.log(contents.length);
		 */
	}

});

// $("선택자 ").action();
// $('#contents').summernote({
// height : 400,
// callbacks:{
// onImageUpload : function(file){
// console.log("upload");
//				 
// }
// }
// });

