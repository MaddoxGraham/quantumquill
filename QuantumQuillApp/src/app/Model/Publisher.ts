import { Book } from "./Book";

export interface Publisher {
    idPublisher: number;
    name: string;
    books: Book[];
  }