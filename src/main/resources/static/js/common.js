$(function () {
    $(document).foundation();
    CanvasParticle();

    $('#btn-search').click(function () {
        if ($('.key-word').val().length > 0) {
            window.location.href = '/doSearch/song/' + $('.key-word').val();
        }
    });

    $('.key-word').focus(function () {
        $(this).keypress(function (event) {
            if (event.keyCode == 13 || event.keyCode == 108) {
                $('#btn-search').click();
            }
        })
    });
})

function songListHover() {
    var target = $(event.target);
    target.css('font-weight', 'bold');
    target.css('font-size', '17px');
    target.find('span').each(function () {
        $(this).css('color', 'black');
    });
    target.find('.btn-play').css('visibility', 'visible');
    target.find('.song-pick').css('visibility', 'visible');
}

function songListOut() {
    var target = $(event.target);
    target.css('font-weight', '');
    target.css('font-size', '');
    target.find('span').each(function () {
        $(this).css('color', 'white');
    });
    target.find('.btn-play').css('visibility', 'hidden');
    target.find('.song-pick').css('visibility', 'hidden');
}