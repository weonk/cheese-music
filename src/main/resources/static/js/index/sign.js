$(function () {
    $('#signin-btn').click(function () {
        var signInUserName = $('#signin-username').val().trim();
        var signInPassword = $('#signin-password').val().trim();

        if (signInUserNameCherk(signInUserName) && signInPasswordCheck(signInPassword)) {
            $('#signin-username-wrong').removeClass("is-visible");
            $('#signin-password-wrong').removeClass("is-visible");
            $.post(
                'user/signIn',
                {
                    account: signInUserName,
                    password: signInPassword
                }, function (data) {
                    if (data === 'fail') {
                        alert("用户名或密码错误！");
                    } else if (data === 'successMember') {
                        window.location.href = 'hotSingle';
                    } else if (data === 'successAdmin') {
                        window.location.href = 'songTable/admin'
                    } else {
                        alert("服务器繁忙，请稍后再试！");
                    }
                }
            );
        } else {
            if (!signInUserNameCherk(signInUserName)) {
                $('#signin-username-wrong').addClass("is-visible");
            }
            if (!signInPasswordCheck(signInPassword)) {
                $('#signin-password-wrong').addClass("is-visible");
            }
        }
    });

    var signUpAccountState = false;

    $('#signup-btn').click(function () {
       var signUpUserName = $('#signup-username').val().trim();
       var signUpEmail = $('#signup-email').val().trim();
       var signUpPassword = $('#signup-password').val().trim();
       signInUserNameCherk(signUpUserName);

       if (signUpAccountState && signupPasswordCheck(signUpPassword) && signUpEmailCheck(signUpEmail)) {
           $('#signup-username-wrong').removeClass('is-visible');
           $('#signup-password-wrong').removeClass('is-visible');
           $('#signup-email-wrong').removeClass('is-visible');
           $.post(
               'user/signUp',
               {
                   account: signUpUserName,
                   email: signUpEmail,
                   password: signUpPassword
               }, function (data) {
                   if (data === 'success') {
                       alert("注册成功！");
                       $('#signup-username').val('');
                       $('#signup-email').val('');
                       $('#signup-password').val('');
                       $('#switcher-signin').click();
                       $('#signin-username').val(signUpUserName);
                   } else {
                       alert('服务器繁忙，注册失败！');
                   }
               }
           );
       } else {
           if (!signupUserNameCherk(signUpUserName)) {
               $('#signup-username-wrong').addClass("is-visible");
           }
           if (!signupPasswordCheck(signUpPassword)) {
               $('#signup-password-wrong').addClass("is-visible");
           }
           if (!signUpEmailCheck(signUpEmail)) {
               $('#signup-email-wrong').addClass("is-visible");
           }
       }
    });

    $('.has-padding').focus(function () {
        $(this).parent().find('span').removeClass('is-visible');
    });

    $('#signin-username').change(function () {
       if (!signInUserNameCherk($(this).val().trim())) {
           $('#signin-username-wrong').addClass('is-visible');
       }
    });

    $('#signin-password').change(function () {
        if (!signInPasswordCheck($(this).val().trim())) {
            $('#signin-password-wrong').addClass('is-visible');
        }
    });

    $('#signup-username').change(function () {
        var reg = /^[a-zA-Z0-9_]+$/;
        var username = $(this).val().trim();
        if (username.length < 6 || username.length > 32) {
            $('#signup-username-wrong').text('呃，长度好像不对，再试试');
            $('#signup-username-wrong').addClass('is-visible');
        } else if (!reg.test(username)) {
            $('#signup-username-wrong').text('呃，格式好像不对，再试试');
            $('#signup-username-wrong').addClass('is-visible');
        } else {
            $.post(
                'user/accountCheck',
                {
                    account: username
                }, function (data) {
                    if (data === true) {

                    } else if (data === false) {
                        $('#signup-username-wrong').text('呃，账号被人用过了，再试试');
                        $('#signup-username-wrong').addClass('is-visible');
                    } else {
                        $('#signup-username-wrong').text('呃，服务器好像睡着了，再等等');
                        $('#signup-username-wrong').addClass('is-visible');
                    }
                }
            );
        }
    });

    $('#signup-password').change(function () {
        if (!signupPasswordCheck($(this).val().trim())) {
            $('#signup-password-wrong').addClass('is-visible');
        }
    });

    $('#signup-email').change(function () {
        if (!signUpEmailCheck($(this).val().trim())) {
            $('#signup-email-wrong').addClass('is-visible');
        }
    });
    
    function signInUserNameCherk(username) {
        var flag = true;
        if (username.length < 6 || username.length > 32) {
            $('#signin-username-wrong').text('呃，长度好像不对，再试试');
            flag = false;
        }
        return flag;
    }

    function signInPasswordCheck(password) {
        var flag = true;
        if (password.length < 6 || password.length > 32) {
            $('#signin-password-wrong').text('呃，长度好像不对，再试试');
            flag = false;
        }
        return flag;
    }

    function signupUserNameCherk(username) {
        var reg = /^[a-zA-Z0-9_]+$/;
        if (username.length < 6 || username.length > 32) {
            $('#signup-username-wrong').text('呃，长度好像不对，再试试');
            signUpAccountState = false;
        } else if (!reg.test(username)) {
            $('#signup-username-wrong').text('呃，格式好像不对，再试试');
            signUpAccountState = false;
        } else {
            $.post(
                'user/accountCheck',
                {
                    account: username
                }, function (data) {
                    if (data === true) {
                        signUpAccountState = true;
                    } else if (data === false) {
                        $('#signup-username-wrong').text('呃，账号被人用过了，再试试');
                        signUpAccountState = false;
                    } else {
                        $('#signup-username-wrong').text('呃，服务器好像睡着了，再等等');
                        signUpAccountState = false;
                    }
                }
            );
        }
    }
    function signupPasswordCheck(password) {
        var flag = true;
        if (password.length < 6 || password.length > 32) {
            $('#signup-password-wrong').text('呃，长度好像不对，再试试');
            flag = false;
        }
        return flag;
    }
    function signUpEmailCheck(email) {
        var flag = true;
        var reg = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
        if (!reg.test(email)) {
            $('#signup-email-wrong').text('呃，格式好像不对，再试试');
            flag = false;
        }
        return flag;
    }

});