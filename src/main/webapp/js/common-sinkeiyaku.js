function changeErrMsg(messageId) {
    $('#hubisyousaibtn').before('<span id="errerMessageSpan" class="fontRed"></span>');

    messageId = String(messageId);
    firstStr = messageId.substr(0, 1);

    var errMsg = '';
    var iconClass = '';
    switch(firstStr) {
      case 'E':
      case 'T':
        errMsg = '不備情報があります！！&nbsp;&nbsp;詳細を確認してください。';
        iconClass = 'errIcon';
        break;
      case 'W':
        errMsg = 'ワーニング情報があります。&nbsp;&nbsp;詳細を確認してください。';
        iconClass = 'warIcon';
        break;
      case 'K':
        errMsg = '不備が特認されています。&nbsp;&nbsp;詳細を確認してください。';
        iconClass = 'tokuninkanouIcon';
        break;
    }

    if (errMsg != '') {
      $('#errerMessageSpan').html(errMsg);

      var hubisyousaiLabelObj = $('#hubisyousaibtn_label');
      hubisyousaiLabelObj.text('');
      hubisyousaiLabelObj.addClass(iconClass);
      hubisyousaiLabelObj.css('display', 'block');

      showGroup('#buttonHubisyousai');
    }
}
