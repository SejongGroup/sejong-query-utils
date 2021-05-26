/* 기본 메뉴 function */
$(function () {
  var trigger = $('#trigger');
  var menu = $('nav ul');
  $(trigger).on('click', function (e) {
    e.preventDefault();
    menu.slideToggle();
  });
  $(window).resize(function () {
    var w = $(window).width();
    if (w > 320 && menu.is(':hidden')) {
      menu.removeAttr('style');
    }
  });
});

function addForm() {
  let target = $('#section-form-parrent');
  let last_form = $(target).children('form').last();
  let last_form_id = $(last_form).attr('id');
  let current_form_split = last_form_id.split('_');
  let current_form_id = current_form_split[0] + '_' + (Number(current_form_split[1]) + 1 );
  let clone_form = last_form.clone(true);

  $(target).append(clone_form.removeAttr('id', last_form_id).attr('id', current_form_id).show());
  return $('#'+current_form_id);
}

function removeForm() {
  let target = $('#section-form-parrent');
  let last_form = $(target).children('form').last();
  let last_form_id = $(last_form).attr('id');
  $(last_form).remove();
}