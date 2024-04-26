function check(){

    if(document.getElementById("kor").value.trim().length == 0){
        alert("국어 점수 란이 입력되지 않았습니다.")
        document.getElementById("kor").focus();
        return false
    }

    if(document.getElementById("math").value.trim().length == 0){
            alert("수학 점수 란이 입력되지 않았습니다.")
            document.getElementById("math").focus();
            return false
    }

    if(document.getElementById("eng").value.trim().length == 0){
            alert("영어 점수 란이 입력되지 않았습니다.")
            document.getElementById("eng").focus();
            return false
    }

    if(document.getElementById("hist").value.trim().length == 0){
            alert("역사 점수 란이 입력되지 않았습니다.")
            document.getElementById("hist").focus();
            return false
    }

    alert("입력이 완료 되었습니다.")
    document.getElementById("form").submit()
    return true

}