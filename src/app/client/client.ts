export class Client{
    id: number;
    firstName: string;
    lastName: string;
    email: string;
    password: string;
    role: string;
    createdOn: Date;
    lastLogin: Date;
    resetToken: string;

    // setClientRole(role:String) {
    //     this.role = role;
    // }

    // getClientRole() {
    //     return this.role;
    // }

    constructor(){
        
    }
}