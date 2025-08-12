let add = (x, y) => {
    return x + y;
};
let sum_ad = add(10, 20);
console.log(sum_ad);
function getFullName(firstName, lastName) {
    if (lastName) {
        console.log(`${firstName}.${lastName}`);
        return;
    }
    console.log('${firstName}');
}
getFullName('Tom', 'Cat');
getFullName('Jerry');
