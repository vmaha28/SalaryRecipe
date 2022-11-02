export interface User{
    username: string
    userFirstName: string
    userLastName: string
    userPassword: string
    role: Role[]
}

export interface Role{
    roleName: string
    roleDescription: string 
} 