import { Component } from '@angular/core';
import { Book } from '../Model/Book';
import { BookService } from '../Service/Book.service';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-book-component',
  templateUrl: './book-component.component.html',
  styleUrls: ['./book-component.component.scss']
})
export class BookComponentComponent {

  public books!: Book[];

  constructor(private bookService : BookService){}

  ngOnInit() {
    this.getBooks();
  }


  public getBooks(): void {
    this.bookService.getBooks().subscribe(
      (response: Book[]) => {
        this.books = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

}
