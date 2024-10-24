import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';
import { User } from 'src/app/shared/models/User';
import { UserValidatorService } from 'src/app/shared/validator/UserValidatorService';

@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.css']
})
export class UserFormComponent {

  userForm: FormGroup;
  user: User = new User();
  errorMessage: string | null = null;

  constructor(private fb: FormBuilder, private userValidator: UserValidatorService,
    private userService: UserService,
    private router: Router,) {

    this.userForm = this.fb.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      phone: ['',Validators.required],
      dateOfBirth: ['', Validators.required],
      imageUrl: ['', Validators.required],
      profession: ['',Validators.required]
    }, { validators: this.userValidator.validate.bind(this.userValidator) });
  }

  ngOnInit(): void {}

  onSubmit(): void {
    if (this.userForm.valid) {
      this.user.dateOfBirth = new Date(this.userForm.value.dateOfBirth).toISOString();

      this.user = { ...this.userForm.value };

      this.userService.addUser(this.user).subscribe({
        next: () => {
          this.router.navigate(['/user-list']);
        },
        error: (err) => {
          console.log(err.error)
          console.log(err.error.message)
          if (err.error && err.error.message) {
            this.errorMessage = err.error.message;
          } else if (err.error && err.error.errors) {
            this.errorMessage = 'Erreurs de validation: ' + err.error.errors.join(', ');
          } else {
            this.errorMessage = 'Une erreur interne du serveur est survenue. Veuillez réessayer.';
          }
        }
      });
    } else {
      console.error('Form errors:', this.userForm.errors);
      alert("Veuillez corriger les erreurs dans le formulaire.");
    }
  }

}


