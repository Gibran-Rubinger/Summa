/*script to do the 'X' moviment on the bars*/
const bars = document.querySelector('.menu-toggle .barsMovimet')
/*script to do the moviment of the toggle menu*/
const menuToggle = document.querySelector('.menu-toggle');
const nav = document.querySelector('nav');
menuToggle.addEventListener('click', () => {
    nav.classList.toggle('active')
    bars.classList.toggle('change')
});

function closeMenu() {
	nav.classList.toggle('active');
};

/*script to change the home photo*/
const changePhoto = document.querySelector('.bg-parlex');
const oldPhoto = document.querySelector('.bg-parlex-new');

           
const headers = new Headers();

const init = { method: 'GET', headers: headers, mode: 'cors', cache: 'default' };

const url = `http://localhost:8080/fetch`;

async function getStocks() {
    try {
        const response = await fetch(url);

        const json = await response.json();

        console.log(json);

        displayData(json); 
        
    } catch (err) {
        console.log(err);
    }
}

// getStocks();

console.log('Has getStocks() finished yet?');

function displayData(data) {
    const stocks = data;
    const output = stocks.map(stock => {
        return `<li>
	        		<div class="card text-center">            
		              <h1 class="card-title">${stock.code}</h1>
		              <p class="card-subtitle mb-2 text-muted">${stock.name}</p>              
		              <p class="card-subtitle mb-2 text-muted">Price</p>
		              <p class="card-text"><i class="fas fa-dollar-sign"></i>${stock.price}</p>
		              <p class="card-subtitle mb-2 text-muted">Market Cap</p>
		              <p class="card-text"><i class="fas fa-arrow-up"></i> ${stock.marketCap}</p>
		              <p class="card-subtitle mb-2 text-muted">Price Change</p>
		              <p class="card-text"><i class="fas fa-arrow-up"></i> ${stock.priceChangePer}</p>
			        </div>
		        </li>`;
    });

    document.getElementById('stocksList').innerHTML = output.join('');
}

