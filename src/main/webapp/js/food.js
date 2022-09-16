//import fetch from '../node_modules/node-fetch';
//import dayjs from '../node_modules/dayjs';
let today = dayjs();
let DayOfWeek = today.format("ddd");

let dt;

if(DayOfWeek == "Sat")
    dt = today.add(2, "d").format("YYYYMMDD");
else if(DayOfWeek == "Sun")
    dt = today.add(1, "d").format("YYYYMMDD");
else
    dt = today.format("YYYYMMDD")

console.log(dt);
dt= dt.toString();

let api_url = "https://open.neis.go.kr/hub/mealServiceDietInfo?key=16c6ed183ccf402dbff0d174ff8a04d7&Type=jsonp&Index=1&pSize=100&ATPT_OFCDC_SC_CODE=B10&SD_SCHUL_CODE=7010126&MLSV_FROM_YMD="+dt+"&MLSV_TO_YMD="+dt;

let lun;
let din;

function loadMenu(){
    return fetch(api_url)
        .then((response)=>response.json())
        .then((json)=>json.mealServiceDietInfo);
}

loadMenu().then((mealServiceDietInfo) => {
    var json = mealServiceDietInfo;

    let lunch = json[1].row[0].DDISH_NM;
    let dinner = json[1].row[1].DDISH_NM;

    lun = lunch.split("<br/>");
    din = dinner.split("<br/>");


    console.log(lun);
    console.log(din);

    for(var i= 0; i <= lun.length ; i++){
    let list = document.getElementById("food_list");
    let listItem = document.createElement("li");
    listItem.innerText = lun[i].toString();
    list.appendChild(listItem);}
});




