var userNum = new Array(5)
var comNum = new Array(5)

dw("당첨 번호");
br();

comNum[0] = Math.floor(Math.random()*45) + 1;
// dw(comNum[0]);
// br();

while(true) {
    comNum[1] = Math.floor(Math.random()*45) + 1;
    if(comNum[1] !== comNum[0]) {
        // dw(comNum[1]);
        // br();
        break;
    }
}

while(true) {
    comNum[2] = Math.floor(Math.random()*45) + 1;
    if(comNum[2] !== comNum[0] && comNum[2] !== comNum[1]) {
        // dw(comNum[2]);
        // br();
        break;
    }
}

while(true) {
    comNum[3] = Math.floor(Math.random()*45) + 1;
    if(comNum[3] !== comNum[0] && comNum[3] !== comNum[1] && comNum[3] !== comNum[2]) {
        // dw(comNum[3]);
        // br();
        break;
    }
}

while(true) {
    comNum[4] = Math.floor(Math.random()*45) + 1;
    if(comNum[4] !== comNum[0] && comNum[4] !== comNum[1] && comNum[4] !== comNum[2] && comNum[4] !== comNum[3]) {
        // dw(comNum[4]);
        // br();
        break;
    }
}

while(true) {
    comNum[5] = Math.floor(Math.random()*45) + 1;
    if(comNum[5] !== comNum[0] && comNum[5] !== comNum[1] && comNum[5] !== comNum[2] && comNum[5] !== comNum[3] && comNum[5] !== comNum[4]) {
        // dw(comNum[5]);
        // br();
        break;
    }
}

dw(comNum);
br();br();

var bonus = 0;
while(true) {
    bonus = Math.floor(Math.random()*45) + 1;
    if(bonus !== comNum[0] && bonus !== comNum[1] && bonus !== comNum[2] && bonus !== comNum[3] && bonus !== comNum[4] && bonus !== comNum[5]) {
    break;
    }
}

dw("보너스 번호: " + bonus);
br();br();

var win = 0;

for(var i = 0; i <= 5; i = i + 1) {
    for(var ii = 0; ii <= 5; ii = ii + 1) {
        if(userNum[i] == comNum[ii]) {
            win = win + 1;
        }
    }
}

dw("일치한 갯수: " + win);
br();

var result = "";

switch(win) {
    case 0:
    case 1:
    case 2:
        result = "다음 기회에...";
    break;

    case 3:
        result = "5등"
    break;
    
    case 4:
        result = "4등"
    break;
    
    case 5:
        result = "3등"

        for(var iii = 0; iii <= 5; iii = iii + 1) {
            if(bonus == userNum[iii]) {
                result = "2등"
            }
        }
    break;
    
    case 6:
        result = "1등"
    break;
}

dw(result);
