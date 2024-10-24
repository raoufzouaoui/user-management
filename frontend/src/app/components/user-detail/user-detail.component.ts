import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { UserService } from 'src/app/services/user.service';
import { User } from 'src/app/shared/models/User';

@Component({
  selector: 'app-user-detail',
  templateUrl: './user-detail.component.html',
  styleUrls: ['./user-detail.component.css']
})
export class UserDetailComponent implements OnInit {
  user!: User;

  constructor(private route: ActivatedRoute, private userService: UserService) { }

  ngOnInit(): void {
    const id = +this.route.snapshot.paramMap.get('id')!;
    this.userService.getUserById(id).subscribe((data: User) => {
      console.log(data)
      this.user = data;
    });
  }
}
