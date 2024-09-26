

# santander dev week 2024

## Diagrama de classes

``` mermaid

classDiagram
    class Usuario {
        +String name
    }
    
    class Conta {
        +String number
        +String agency
        +float balance
        +float limit
    }
    
    class Feature {
        +String icon
        +String description
    }
    
    class Cartao {
        +String number
        +float limit
    }
    
    class Novidade {
        +String icon
        +String description
    }

    Usuario "1" *--  "1" Conta : possui
    Usuario "1" *-- "N" Feature : possui * 
    Usuario "1" *-- "1" Cartao : possui
    Usuario "1" *-- "N" Novidade : possui
```
