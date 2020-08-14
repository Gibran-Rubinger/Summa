const signUpForm = document.getElementById('registration');
const createUserName = document.getElementById('createUserName');
const createUserEmail = document.getElementById('createUserEmail');
const createUserPassword = document.getElementById('createUserPassword');
const createUserRepeatPassword = document.getElementById('createUserRepeatPassword');
const createUserAcceptTerms = document.getElementById('createUserCheckbox624');
const signUpErrorElement = document.getElementById('signUpError');

signUpForm.addEventListener('submit', (e) => {
    let messages = []

    if ( createUserName.value === '' || createUserName.value === null ) {
        messages.push('Please insert your name')
    }
    
    // regular expression for email validation
   // let reg = "@";
    //if (reg.test(createUserEmail) === false) {
    //    messages.push('Please insert a valid email')
    //}

    if ( createUserPassword.value.length <= 5 ) {
        messages.push('Your password should have at least 6 characters')
    }

    if ( createUserPassword.value !== createUserRepeatPassword.value ) {
        messages.push('Please make sure you repeat your password in the required field')
    }

    if ( createUserAcceptTerms === false ) {
        messages.push('Please accept terms and conditions to proceed')
    }

    if (messages.length > 0) {
        e.preventDefault()
        signUpErrorElement.innerText = messages.join(', ')
    }
    
})