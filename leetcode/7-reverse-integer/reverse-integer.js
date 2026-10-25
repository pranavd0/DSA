/**
 * @param {number} x
 * @return {number}
 */
var reverse = function(x) {
    let iRev = 0
    let iDigit = 0
    let bRet = false

    if(x<0)
    {
        bRet= true
    }

    while( x != 0)
    {
        iDigit = x % 10
        iRev = iRev * 10 + Math.abs(iDigit)
        x = Math.trunc(x / 10)
    }

    if(bRet)
    {
        return -iRev
    }
    else
    {
        return iRev
    }
};
