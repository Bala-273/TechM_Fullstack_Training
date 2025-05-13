import './styles/App.css'
import NavBar from './components/NavBar'
import Home from './pages/Home'
import Favorites from './pages/Favorites'
import {Routes, Route} from 'react-router-dom'
import { MovieProvider } from './contexts/MovieContext'
import AddMovie from './pages/AddMovie'
function App() {

  return (
    <MovieProvider>
      <NavBar />
      <main className="main-content">
        <Routes>
          <Route path='/' element={<Home />}></Route>
          <Route path = '/favorites' element={<Favorites />}></Route>
          <Route path = '/addmovie' element={<AddMovie />}></Route>
        </Routes>
      </main>
    </MovieProvider>
  )
}

export default App
