# clojure-airpi

An API built to handle aircrafts information (for educational purposes) 

## Usage

### Running
To start a web server for the application, run:

```
lein ring server
```
The service should be available on `localhost:3000`

### Testing
Tests were built using [Midje](https://github.com/marick/Midje) framework

```
lein test :all
```

## Dependencies
- [Cheshire](https://github.com/dakrone/cheshire)
- [Midje](https://github.com/marick/Midje)
- [Ring](https://github.com/ring-clojure/ring)
- [Compojure](https://github.com/weavejester/compojure)
