package main

import (
    "fmt"
    "time"
)

func main() {
    fmt.Println("Starting Go Routines")
    go func() {
        time.Sleep(1 * time.Microsecond)
        for char := 'a'; char < 'a'+5; char++ {
            fmt.Printf("%c ", char)
        }
    }()

    go func() {
        for number := 1; number < 5; number++ {
            fmt.Printf("%d ", number)
        }
    }()

    fmt.Println("Waiting To Finish")
    time.Sleep(1 * time.Second)
    fmt.Println("\nTerminating Program")
}
