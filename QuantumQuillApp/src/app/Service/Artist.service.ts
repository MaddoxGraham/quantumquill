import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { HttpClient } from '@angular/common/http';
import { Artist } from "../Model/Artist";

@Injectable({
    providedIn:'root'
})
export class ArtistService{
    private apiServerUrl='http://localhost:8080';

    constructor(private http: HttpClient) { }
        
    public getArtists(): Observable<Artist[]> {
        return this.http.get<Artist[]>(`${this.apiServerUrl}/artist/all`);
    }

    public addArtist(artist: Artist): Observable<Artist> {
        return this.http.post<Artist>(`${this.apiServerUrl}/artist/add`, artist);
    }

    public udpateArtist(artist: Artist): Observable<Artist> {
        return this.http.put<Artist>(`${this.apiServerUrl}/artist/update`, artist);
    }

    public deleteArtist(artistId: number): Observable<void> {
        return this.http.delete<void>(`${this.apiServerUrl}/artist/delete/${artistId}`);
    }

    
}