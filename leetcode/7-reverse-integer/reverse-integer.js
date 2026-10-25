/**
 * @param {number} x
 * @return {number}
 */
var reverse = function(x) {
    let iRev = 0;
    let iDigit = 0;
    let bRet = false;

    if (x < 0) {
        bRet = true;
        x = Math.abs(x);
    }

    while (x > 0) {
        iDigit = x % 10;
        iRev = (iRev * 10) + iDigit;
        x = Math.floor(x / 10);
    }

    if (iRev > Math.pow(2, 31) - 1) {
        return 0;
    }

    if (bRet == true) {
        return -iRev;
    }
    return iRev;
};
