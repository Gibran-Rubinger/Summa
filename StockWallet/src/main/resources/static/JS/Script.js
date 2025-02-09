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
    var variation = "";
    if(stock.priceChangePer >0.00){
      variation= `<i class="fas fa-arrow-up" id="arrowup"></i>`;
    }else{
      variation=`<i class="fas fa-arrow-down" id="arrowdo"></i>`;
    }
    return `<li>
    <div class="card">   
    <div class="stockcode">
          		<h2 class="stockcode">${stock.code}</h2>
          	 </div> 
          	 
          	         
             <div class="cname">
             	<h5>${stock.name}</h5>
             </div>
             
             
              <div class="price">
              	<h2><i class="fas fa-pound-sign" id="pounds"></i>${stock.price}</h2>
              	<p class="card-subtitle mb-2 text-muted">Price</p>
              </div> 
              
              
            <div class=baseprice>  
              <div class="org-itens">
                <i class="fas fa-chart-line" id="chart"></i>
                ${stock.marketCap}
              </div>
              <div>
                Market Cap
              </div>
           </div>
           <div class="baseprice">
           <div class="org-itens">
              ${variation}
              ${stock.priceChangePer}
              <i class="fas fa-percentage"></i>
           </div>
              <div>
                Price Change
              </div>
              
            </div>   
          </div>
        </li>`; 
    });

    document.getElementById('stocksList').innerHTML = output.join('');
}

