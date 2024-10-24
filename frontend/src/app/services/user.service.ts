import { Injectable } from '@angular/core';
import { User } from '../shared/models/User';
import { Observable } from 'rxjs';
import { GET_USER_BY_EMAIL, GET_USER_BY_ID, GET_ALL_USERS,ADD_USER } from 'src/app/shared/constants/urls';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) {}

  addUser(user: User): Observable<User> {
    return this.http.post<User>(ADD_USER, user);
  }

  getUserByEmail(email: string): Observable<User> {
    return this.http.get<User>(GET_USER_BY_EMAIL+email);
  }

  getUserById(id: number): Observable<User> {
    return this.http.get<User>(GET_USER_BY_ID+id);
  }

  getAllUsers(): Observable<User[]> {
    return this.http.get<User[]>(GET_ALL_USERS);
  }
}
