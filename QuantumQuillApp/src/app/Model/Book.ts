import { Artist } from "./Artist";
import { Genre } from "./Genre";
import { Publisher } from "./Publisher";


export interface Book {
    idBook: number;
    title: string;
    totalRatings: number;
    rating: number;
    publishedDate: Date;
    resume: string;
    tome: number;
    imageUrl: string;
    genres: Genre[];
    publisher: Publisher;
    artists: Artist[];
  }