import { Injectable } from '@angular/core';
import { AbstractControl, ValidationErrors, ValidatorFn } from '@angular/forms';

@Injectable({
  providedIn: 'root'
})
export class UserValidatorService {

  validate: ValidatorFn = (control: AbstractControl): ValidationErrors | null => {
    const errors: ValidationErrors = {};

    const userDto = control.value;

    if (!userDto.firstName) {
      errors['firstNameRequired'] = true;
    }
    if (!userDto.lastName) {
      errors['lastNameRequired'] = true;
    }
    if (!userDto.email) {
      errors['emailRequired'] = true;
    } else if (!this.validateEmail(userDto.email)) {
      errors['invalidEmail'] = true;
    }
    if (!userDto.phone) {
      errors['phoneRequired'] = true;
    }
    if (!userDto.dateOfBirth) {
      errors['dateOfBirthRequired'] = true;
    }
    if (!userDto.imageUrl) {
      errors['imageUrlRequired'] = true;
    }
    if (!userDto.profession) {
      errors['professionRequired'] = true;
    }
    return Object.keys(errors).length ? errors : null;
  }

  private validateEmail(email: string): boolean {
    const re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/; 
    return re.test(email);
  }
}
