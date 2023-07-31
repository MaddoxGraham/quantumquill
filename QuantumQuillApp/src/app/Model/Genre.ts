import { Book } from "./Book";

export interface Genre {
  idGenre: number;
  name: string;
  books: Book[];
}