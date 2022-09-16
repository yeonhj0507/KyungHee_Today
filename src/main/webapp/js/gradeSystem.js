let subject = {
    num : [],
    score : [],
    ans : []
};

function addInform (num, score, ans){
    subject.num = num;
    subject.score = score;
    subject.ans = ans;
}
let subName = 3;

switch (subName) {
    case 1 :
        addInform([],[],[]);
        break;
    case 2 :
        addInform([], [], []);
        break;
    case 3 :
        addInform([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20], [3,3.5,3.6,3.9,4,4.1,4.2,4.3,4,4,5,5.3,5.5,5.6,6.4,6.6,6.6,6.8,6.7,6.9], ['4','3','5','1','3','4','2','5','1','1','2','3','4','2','16',"329/45",'10','15','9','341']);
        break;
}

let ansBox = document.getElementById('box');
let resultBox = document.getElementById('result');
    resultBox.style.display = "none";

    for (let i = 0; i < subject.num.length / 10; i++) {
        let mold = document.createElement('div');
        mold.className = "row";
        mold.id = "mold" + i;
        for (let j = 0; j < 10; j++) {
            let col = document.createElement('div');
            col.className = "col-sm";
            let num = i * 10 + j + 1;
            col.id = 'div' + num;
            let input = document.createElement('input');
            input.className = "form-control";
            input.type = "text";
            input.placeholder = 10 * i + j + 1 + "번"
            input.id = 'input' + num;
            col.appendChild(input);
            mold.appendChild(col);
        }
        let br = document.createElement('br');
        ansBox.appendChild(mold);
        ansBox.appendChild(br);
    }

let ansOutput = [];
let sumScore = 100;
let Enum = 0;

function correction() {
    let input;
    for(let i=1; i<=subject.num.length; i++) {
        input = document.getElementById('input'+i);
        if(input.value == subject.ans[i] ) {
            ansOutput[i] = 'O';
            console.log('O');
        } else {
            ansOutput[i] = 'X';
            console.log('X');
            sumScore = sumScore - subject.score[i-1];
            Enum++;
        }
    }
    sumScore *= 10;
    sumScore /= 10;
    document.getElementById('score').innerText= sumScore.toString();
    document.getElementById('Enum').innerText= Enum.toString();
    document.getElementById('submit').style.display ='none';
    resultBox.style.display = "block";
    ansBox.style.display = "none";
}



