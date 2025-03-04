// Sample News Data
const newsData = {
    home: [
        {title: "Tech Breakthrough", img: "https://th.bing.com/th/id/OIP.3vGTq1AVXPHRMBCr6W7EEgHaD4?w=323&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7", link: "https://www.indiatoday.in/technology/features/story/microsoft-majorana-1-what-is-it-how-it-works-what-it-means-for-you-and-everything-else-explained-2683437-2025-02-21"},
        {title: "Economic Summit", img: "https://th.bing.com/th/id/OIP._raZB_Z1BGIQwUAXZKr5CwAAAA?w=299&h=173&c=7&r=0&o=5&dpr=1.3&pid=1.7", link: "https://www.weforum.org/meetings/india-economic-summit/"},
        {title: "AI in Healthcare", img: "https://th.bing.com/th/id/OIP.v-7N0NfEc65NUU44Nu68FQHaEK?w=321&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7", link: "https://en.wikipedia.org/wiki/Artificial_intelligence_in_healthcare"},
        {title: "Green Energy Advances", img: "https://th.bing.com/th/id/OIP.RprD508Lod5k1E8sAib0dwHaEe?w=292&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7", link: "https://setr.stanford.edu/technology/sustainable-energy-technologies/2025"},
        {title: "Cybersecurity Concerns", img: "https://th.bing.com/th/id/OIP.R6128h-YpvZUkNppZr6Q5AHaD3?w=328&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7", link: "https://www.sciencedirect.com/science/article/pii/S2772918423000188"},
        {title: "Space Exploration", img: "https://th.bing.com/th/id/OIP.b5DkOywODFgCeFIr4PoAzAHaEo?w=283&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7", link: "https://www.nasa.gov/humans-in-space/why-go-to-space/"}
    ],
    sports: [
        {title: "Championship Final", img: "https://th.bing.com/th?id=OIF.iEn1o3hc5Hp%2bm5wDRehapg&w=318&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7", link: "https://www.cricbuzz.com/live-cricket-scorecard/112462/ind-vs-aus-1st-semi-final-a1-v-b2-icc-champions-trophy-2025"},
        {title: "Olympics Updates", img: " https://th.bing.com/th/id/OIP.dTvYWFiuSMkD-anpkDuQPQHaEK?w=275&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7", link: "https://www.turin2025.org/en  "},
        {title: "New Football Records", img: "https://th.bing.com/th/id/OIP.Dd7ZKUNJXYw0-e5QVUM8kQHaEk?w=301&h=185&c=7&r=0&o=5&dpr=1.3&pid=1.7", link: "https://the18.com/news/18-greatest-world-records-football-history"},
        {title: "Tennis Grand Slam", img: "https://th.bing.com/th/id/OIP.oGZWOCOVvaUyf7JfPdHuVwHaE8?w=294&h=197&c=7&r=0&o=5&dpr=1.3&pid=1.7", link: "https://www.atptour.com/en"},
        {title: "Cricket World Cup", img: "https://th.bing.com/th/id/OIP.UQ0FmAHfMloR_6jw_TPaBgHaE1?w=257&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7", link: "https://www.icc-cricket.com/tournaments/t20cricketworldcup"},
        {title: "F1 Racing Championship", img: "https://th.bing.com/th/id/OIP.MZXKfOCL6VEwviA64QN5ugHaE8?w=274&h=183&c=7&r=0&o=5&dpr=1.3&pid=1.7", link: "https://www.24hseries.com/news/2025-michelin-24h-dubai-ajith-kumar-racing-debut"}
    ],
    economics: [
        {title: "Stock Market Trends", img: "https://th.bing.com/th/id/OIP.8Mgtw74F9qSyq07p4bTMTwHaEK?w=321&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7", link: "https://www.nseindia.com/"},
        {title: "Crypto Updates", img: "https://th.bing.com/th/id/OIP.2CqtMdD5u4BaXXdHGAvRvgHaEK?w=307&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7", link: "https://cryptonews.com/"},
        {title: "Inflation Analysis", img: "https://th.bing.com/th/id/OIP.TaDgOoYWIgPe0PWInWGLFwAAAA?rs=1&pid=ImgDetMain", link: "https://www.economicsdiscussion.net/inflation/inflation-types-causes-and-effects-with-diagram/6401"},
        {title: "Banking Innovations", img: "https://th.bing.com/th/id/OIP.L0zyoccn1FhAIssdFjkO7gHaEs?w=996&h=632&rs=1&pid=ImgDetMain", link: "https://thefinancialbrand.com/news/banking-innovation/5-banking-innovation-trends-to-watch-in-next-3-years-metaverse-ai-digital-banking-139577"},
        {title: "Real Estate Growth", img: "https://th.bing.com/th/id/OIP.T7wSDKVAYX1muKKur6hq3gHaDP?w=343&h=153&c=7&r=0&o=5&dpr=1.3&pid=1.7", link: "https://www.magicbricks.com/"},
        {title: "World Economy Overview", img: "https://miro.medium.com/max/1200/0*BGrCOkTaDIK6TXD6.jpg", link: "https://www.imf.org/en/Publications/WEO"}
    ],
    technology: [
        {title: "New AI Development", img: "https://th.bing.com/th/id/OIP.v-7N0NfEc65NUU44Nu68FQHaEK?w=321&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7", link: "https://en.wikipedia.org/wiki/Artificial_intelligence_in_healthcare"},
        {title: "Quantum Computing", img: "https://th.bing.com/th/id/OIP.3vGTq1AVXPHRMBCr6W7EEgHaD4?w=323&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7", link: "https://www.indiatoday.in/technology/features/story/microsoft-majorana-1-what-is-it-how-it-works-what-it-means-for-you-and-everything-else-explained-2683437-2025-02-21"},
        {title: "SpaceX Mars Mission", img: "https://th.bing.com/th/id/OIP.SMDf8KL5APOe4dvfzdoGSgHaE8?w=254&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7", link: "https://www.spacex.com/humanspaceflight/mars/"},
        {title: "Self-Driving Cars", img: "https://th.bing.com/th/id/OIP.CqmOyRO8v1kh-XsW4oUe2wHaE7?w=270&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7", link: "https://www.infineon.com/cms/en/product/promopages/dependable-electronics/?gclid=eeee96906d8b1f2365a4f1561c656c33&gclsrc=3p.ds&msclkid=eeee96906d8b1f2365a4f1561c656c33&utm_source=bing&utm_medium=cpc&utm_campaign=asia-atv-en-bs-g_dependability.atv.s.dependable&utm_term=autonomous%20vehicle%20technology&utm_content=as-atv-en-bs-g_dependability.atv.s.dependable_products_dependable%20electronics"},
        {title: "5G Expansion", img: "https://th.bing.com/th/id/OIP.99c6T995DJm7GYFSXjm88gHaEK?w=288&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7", link: "https://www.businesstoday.in/technology/news/story/indias-5g-growth-story-government-reports-5g-rollout-in-779-districts-highlights-infrastructure-growth-457233-2024-12-13"},
        {title: "Cybersecurity Trends", img: "https://th.bing.com/th/id/OIP.R6128h-YpvZUkNppZr6Q5AHaD3?w=328&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7", link: "https://www.sciencedirect.com/science/article/pii/S2772918423000188"}
    ],
    entertainment: [
        {title: "Award Show Highlights", img: "https://th.bing.com/th/id/OIP.3M0IOLf3DSZZAGqMzjioagHaE7?w=258&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7", link: "https://apnews.com/live/oscars-2025-updates"},
        {title: "New Movie Releases", img: "https://th.bing.com/th/id/OIP.SNX_ULBR231iUBKA5zZBXQHaEK?w=279&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7", link: "https://www.91mobiles.com/entertainment/new-movies"},
        {title: "Celebrity Interviews", img: "https://th.bing.com/th/id/OIP.ADlbSuunV9C_3IBoZJMbDwHaEK?w=290&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7", link: "https://youtu.be/o3DiFCjXYAk?si=HhCRVZsEJancYhKD"},
        {title: "Music Industry Updates", img: "https://th.bing.com/th/id/OIP.S0ogxxBFtpfiEck8Ss79QgHaEz?w=278&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7", link: "https://www.billboard.com/c/music/music-news/"},
        {title: "Streaming Wars", img: "https://th.bing.com/th/id/OIP.QY5uGZVH2qG3J1Fr3LETAwHaEK?w=312&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7", link: "https://www.latimes.com/entertainment-arts/business/story/2024-03-06/how-netflix-held-onto-its-crown-as-king-of-streaming"},
        {title: "Broadway Comeback", img: "https://th.bing.com/th/id/OIP.ASJcTkKkbCXijo4OFtFnTwHaEK?w=266&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7", link: "https://edition.cnn.com/2021/09/02/entertainment/broadway-returns-new-york/index.html"}
    ]
}; 

document.getElementById('search-bar').addEventListener('input', function () {
    let searchTerm = this.value.toLowerCase();
    let articles = document.querySelectorAll('.article-card');

    articles.forEach(article => {
        let title = article.querySelector('h3').textContent.toLowerCase();
        article.style.display = title.includes(searchTerm) ? 'block' : 'none';
    });
});


function initializePage() {
    setupCategorySections();
    
    setupEventListeners();
    
    showCategory('home');
    loadSlider();
}

function setupCategorySections() {
    const categories = ['sports', 'economics', 'technology', 'entertainment'];
    const container = document.querySelector('.container');

    categories.forEach(category => {
        const section = document.createElement('section');
        section.className = 'category-section';
        section.id = `${category}-news`;
        section.innerHTML = `
            <h2>${category.charAt(0).toUpperCase() + category.slice(1)} News</h2>
            <div class="articles-grid"></div>
        `;
        container.appendChild(section);
    });
}

function setupEventListeners() {
    document.querySelectorAll('.nav-link').forEach(link => {
        link.addEventListener('click', function (e) {
            e.preventDefault();
            const category = this.dataset.category;
            document.querySelectorAll('.nav-link').forEach(l => l.classList.remove('active'));
            this.classList.add('active');
            showCategory(category);
        });
    });

    document.getElementById('commentForm').addEventListener('submit', function (event) {
        event.preventDefault();
        const name = document.getElementById('name').value;
        const email = document.getElementById('email').value;
        const comment = document.getElementById('comment').value;

        if (name && email && comment) {
            const commentItem = document.createElement('li');
            commentItem.innerHTML = `<strong>${name}</strong>: ${comment}`;
            document.getElementById('comments-display').appendChild(commentItem);
            this.reset();
        }
    });
}



function showCategory(category) {
    document.querySelectorAll('.category-section').forEach(section => section.classList.remove('active'));
    
    const activeSection = document.getElementById(`${category}-news`);
    if (activeSection) {
        activeSection.classList.add('active');
    }

    const slider = document.querySelector('.slider-container');
    slider.classList.toggle('hidden', category !== 'home');
    
    if (category === 'home') {
        loadSlider();
    }
    
    displayNews(category);
}




function showCategory(category) {
    document.querySelectorAll('.category-section').forEach(section => section.classList.remove('active'));
    document.getElementById(`${category}-news`).classList.add('active');
    displayNews(category);
}



// Function to Display News
function displayNews(category) {
    const section = document.querySelector(`#${category}-news .articles-grid`);
    section.innerHTML = ''; 

    newsData[category].slice(0, 6).forEach(article => {
        const articleEl = document.createElement('div');
        articleEl.className = 'article-card';
        articleEl.innerHTML = `
            <img src="${article.img}" alt="News Image">
            <div class="article-content">
                <h3>${article.title}</h3>
                <a href="${article.link}" target="_blank">Read More</a>
            </div>
        `;
        section.appendChild(articleEl);
    });
} 

document.getElementById('commentForm').addEventListener('submit', function (event) {
    event.preventDefault();

    let name = document.getElementById('name').value;
    let email = document.getElementById('email').value;
    let comment = document.getElementById('comment').value;

    if (name && email && comment) {
        let commentList = document.getElementById('comments-display');
        let commentItem = document.createElement('li');
        commentItem.innerHTML = `<strong>${name}</strong>: ${comment}`;
        commentList.appendChild(commentItem);

        document.getElementById('name').value = '';
        document.getElementById('email').value = '';
        document.getElementById('comment').value = '';
    }
});

document.addEventListener('DOMContentLoaded', () => {
    showCategory('home');
});




document.querySelectorAll('.nav-link').forEach(link => {
    link.addEventListener('click', function (e) {
        e.preventDefault();
        const category = this.dataset.category;
        document.querySelectorAll('.nav-link').forEach(l => l.classList.remove('active'));
        this.classList.add('active');
        showCategory(category);
    });
});





function showCategory(category) {
    document.querySelectorAll('.category-section').forEach(section => section.classList.remove('active'));
    document.getElementById(`${category}-news`).classList.add('active');

    const slider = document.querySelector('.slider-container');
    if (category === "home") {
        slider.classList.remove('hidden');
        loadSlider(); 
    } else {
        slider.classList.add('hidden');
    }

    displayNews(category);
}

function loadSlider() {
    const sliderContainer = document.querySelector('.slider');

    if (!sliderContainer) return;

    sliderContainer.innerHTML = ''; 

    newsData.home.slice(0, 5).forEach((article) => {
        const slide = document.createElement('div');
        slide.className = 'carousel-item';
        slide.innerHTML = `
            <img src="${article.img}" alt="News Image">
            <div class="carousel-caption">
                <h2>${article.title}</h2>
                <p><a href="${article.link}" target="_blank" style="color:#f39c12; text-decoration: none;">Read More</a></p>
            </div>
        `;
        sliderContainer.appendChild(slide);
    });

    startSlider();
}

let currentIndex = 0;
let autoSlideInterval;

function startSlider() {
    const slides = document.querySelectorAll('.carousel-item');
    const slider = document.querySelector('.slider');
    const totalSlides = slides.length;

    function updateSlide() {
        slider.style.transform = `translateX(-${currentIndex * 100}%)`;
    }

    function moveNextSlide() {
        currentIndex = (currentIndex + 1) % totalSlides;
        updateSlide();
    }

    function movePrevSlide() {
        currentIndex = (currentIndex - 1 + totalSlides) % totalSlides;
        updateSlide();
    }

    document.querySelector('.next-slide').addEventListener('click', moveNextSlide);
    document.querySelector('.prev-slide').addEventListener('click', movePrevSlide);

    function startAutoSlide() {
        autoSlideInterval = setInterval(moveNextSlide, 4000);
    }

    slider.parentElement.addEventListener('mouseenter', () => clearInterval(autoSlideInterval));
    slider.parentElement.addEventListener('mouseleave', startAutoSlide);

    startAutoSlide();
}

document.addEventListener('DOMContentLoaded', () => {
    loadSlider();
});

