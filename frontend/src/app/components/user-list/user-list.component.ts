import { HttpErrorResponse } from '@angular/common/http';
import { Component } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { User } from 'src/app/shared/models/User';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent {

  users: User[] = [];
  searchTerm: string = '';

  constructor(private userService: UserService) {}

  ngOnInit(): void {
    this.getUsers();
  }

  public getUsers(){
    this.userService.getAllUsers().subscribe(data => {
      console.log(data)
      this.users = data;
    },(error:HttpErrorResponse) => {
      alert(error);
    })
  }


  public searchUsers(key: string): void {
    console.log(key);
    const results: User[] = [];
    if(this.users)
      for (const user of this.users) {
        if (user.firstName.toLowerCase().indexOf(key.toLowerCase()) !== -1
        || user.lastName.toLowerCase().indexOf(key.toLowerCase()) !== -1
        || user.email.toLowerCase().indexOf(key.toLowerCase()) !== -1
        || user.phone.toLowerCase().indexOf(key.toLowerCase()) !== -1
        || user.profession.toLowerCase().indexOf(key.toLowerCase()) !== -1
        ) {
          results.push(user);
        }
      }
    this.users = results;
    if (results.length === 0 || !key) {
      this.getUsers();
    }
  }
}
