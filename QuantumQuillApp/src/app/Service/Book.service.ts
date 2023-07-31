import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { HttpClient } from '@angular/common/http';
import { Book } from "../Model/Book";

@Injectable({
    providedIn:'root'
})
export class BookService{
    private apiServerUrl='http://localhost:8080';

    constructor(private http: HttpClient) { }
        
    public getBooks(): Observable<Book[]> {
        return this.http.get<Book[]>(`${this.apiServerUrl}/book/all`);
    }

    public addBook(book: Book): Observable<Book> {
        return this.http.post<Book>(`${this.apiServerUrl}/book/add`, book);
    }

    public udpateBook(book: Book): Observable<Book> {
        return this.http.put<Book>(`${this.apiServerUrl}/book/update`, book);
    }

    public deleteBook(bookId: number): Observable<void> {
        return this.http.delete<void>(`${this.apiServerUrl}/book/delete/${bookId}`);
    }

    
}