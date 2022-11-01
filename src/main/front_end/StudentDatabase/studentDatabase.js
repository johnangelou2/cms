function displayRows(){
    var code = '';
    for (let i = 0; i<10; i++){
        code = code + '<tr>';
        for (let j = 0; j<6; i++){
        code = code +'<td> a </td>';
        }
        code = code + '</tr>';
    }
    document.getElementById("rows").innerHTML=code;
}