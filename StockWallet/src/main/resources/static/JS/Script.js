/*script to do the 'X' moviment on the bars*/
const bars = document.querySelector('.menu-toggle .barsMovimet')
/*script to do the moviment of the toggle menu*/
const menuToggle = document.querySelector('.menu-toggle');
const nav = document.querySelector('nav');
menuToggle.addEventListener('click', () => {
    nav.classList.toggle('active')
    bars.classList.toggle('change')
});
/*script to change the home photo*/
const changePhoto = document.querySelector('.bg-parlex');
const oldPhoto = document.querySelector('.bg-parlex-new');

            

// function createNode(element) {
//     return document.createElement(element);
// }

// function append(parent, el) {
//   return parent.appendChild(el);
// }



// function fetchStocks() {
// fetch('http://localhost:8080/fetch').then((data) => {
//   const response = data.json();
//     return response.map(function(stock) {
//         let li = createNode('li'),
//             div = createNode('div'),
//             h1 = createNode('h1'),
//             h6 = createNode('h6'),
//             h3 = createNode('h3'),;
//         h1.innerHTML = `${stock.code}`;
//         h6.innerHTML = `${stock.name}`;
//         h3.innerHTML = `${stock.price}`;
//         append(li, div);
//         append(div, h1);
//         append(div, h6);
//         append(div, h3);
//         append(ul, li);
//     })
// })
// };

fetch('http://localhost:8080/fetch').then((data) => {
  const response = data.json();
  console.log(response);
});