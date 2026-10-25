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

    while (x != 0) {
        iDigit = x % 10;
        iRev = iRev * 10 + iDigit;
        x = Math.trunc(x / 10);
    }

    if (bRet) {
        iRev = -iRev;
    }

    if (iRev < -2147483648 || iRev > 2147483647) {
        return 0;
    }

    return iRev;
};
