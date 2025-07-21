import './styles/App.css'
import NavBar from './components/NavBar'
import Home from './pages/Home'
//import Favorites from './pages/Favorites'
import {Routes, Route} from 'react-router-dom'
import { MovieProvider } from './contexts/MovieContext'
import AddMovie from './pages/AddMovie'
import { lazy, Suspense } from 'react'

const Favorites = lazy(() => import('./pages/Favorites'))
function App() {

  return (
    <MovieProvider>
      <NavBar />
      <Suspense fallback={<div className='spinner'>Loading...</div>}>
      <main className="main-content">
        <Routes>
          <Route path='/' element={<Home />}></Route>
          <Route path = '/favorites' element={<Favorites />}></Route>
          <Route path = '/addmovie' element={<AddMovie />}></Route>
        </Routes>
      </main>
      </Suspense>
    </MovieProvider>
  )
}

export default App
