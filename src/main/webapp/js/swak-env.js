var REGEXP_URL_PATTERN = "^/.+(\.do$|\.do\?.*)";

var MODAL_DIALOG_SIZE = new ModalDialogSize("default", 1210, 650);

function ModalDialogSize(id, width, height) {
    this.array = new Array();
    this.array.push(new Array(id, width, height));
}

ModalDialogSize.prototype.getWidth = function(id) {
    var DEFAULT = 0;
    var ID = 0;
    var WIDTH = 1;
    for (var i = 0; i < this.array.length; i++) {
        if (this.array[i][ID] == id) {
            return this.array[i][WIDTH];
        }
    }
    return this.array[DEFAULT][WIDTH];
}

ModalDialogSize.prototype.getHeight = function(id) {
    var DEFAULT = 0;
    var ID = 0;
    var HEIGHT = 2;
    for (var i = 0; i < this.array.length; i++) {
        if (this.array[i][ID] == id) {
            return this.array[i][HEIGHT];
        }
    }
    return this.array[DEFAULT][HEIGHT];
}

ModalDialogSize.prototype.setSize = function(id, width, height) {
    this.array.push(new Array(id.replace(/(#|\\)/g, ""), width, height));
}

var REPORT_WINDOW_WIDTH = Math.floor((parseInt(screen.height)-140)/Math.sqrt(2));
var REPORT_WINDOW_HEIGHT =  parseInt(screen.height) - 140;
var REPORT_WINDOW_FEATURES = "width="+ REPORT_WINDOW_WIDTH +", height=" + REPORT_WINDOW_HEIGHT + ", top=0, left=" + screen.width + ", scrollbars=yes, toolbar=yes, menubar=yes, status=no, directories=yes, resizable=yes";

var SUB_WINDOW_FEATURES = {
  defaultFeatures : "scrollbars=yes, toolbar=no, menubar=no, status=no, location=no, directories=no, resizable=yes",
  customFeatures : "scrollbars=yes, toolbar=yes, menubar=no, status=no, location=no, directories=no, resizable=yes",
  targetUrl : ["/base/system/usertouroku/UserTouroku.do",
               "/biz/bzmaster/bzketteisya/BzKetteisya.do",
               "/biz/bzmaster/bzsimekiribi/BzSimekiribi.do",
               "/biz/bzmaster/bzsyokugyou/BzSyokugyou.do",
               "/biz/bzmaster/bzsyoubyou/BzSyoubyou.do",
               "/workflow/processkanri/hozenworklist/HozenWorkList.do",
               "/workflow/processkanri/jimuyoucodenyuuryoku/JimuyouCodeNyuuryoku.do",
               "/workflow/processkanri/kouteijyoukyousyoukai/KouteiJyoukyouSyoukai.do",
               "/workflow/processkanri/kouteikaisitouroku/KouteiKaisiTouroku.do",
               "/workflow/processkanri/kouteitorikesi/KouteiTorikesi.do",
               "/workflow/processkanri/siharaiworklist/SiharaiWorkList.do",
               "/workflow/processkanri/sinkeiyakuworklist/SinkeiyakuWorkList.do",
               "/workflow/processkanri/syorikensuusyoukai/SyoriKensuuSyoukai.do",
               "/workflow/processkanri/tantousyabetusyoritasksyoukai/TantousyabetuSyoriTaskSyoukai.do",
               "/workflow/processkanri/wariatekaijyo/WariateKaijyo.do",
               "/sinkeiyaku/skmousikomi/skmousikomisyo/SkMousikomisyo.do",
               "/sinkeiyaku/skmousikomi/skkokutisyo/SkKokutisyo.do",
               "/sinkeiyaku/skmousikomi/skmousikomitenken/SkMousikomiTenken.do",
               "/sinkeiyaku/skhubikanri/skhubitouroku/SkHubiTouroku.do",
               "/sinkeiyaku/skhubikanri/skhubikaisyou/SkHubiKaisyou.do",
               "/sinkeiyaku/skkettei/skkankyousatei/SkKankyouSatei.do",
               "/sinkeiyaku/skkettei/skimusatei/SkImuSatei.do",
               "/sinkeiyaku/skkettei/skkeiyakukakuninirai/SkKeiyakuKakuninIrai.do",
               "/sinkeiyaku/skkettei/skkeiyakukakuninkekka/SkKeiyakuKakuninKekka.do",
               "/sinkeiyaku/skkettei/sktokunin/SkTokunin.do",
               "/sinkeiyaku/skkettei/skkyouseihand/SkKyouseiHand.do",
               "/sinkeiyaku/skkettei/skkankyousatei/SkKankyouSatei.do?_eventHandler=initMousikomitorikesi",
               "/sinkeiyaku/skkettei/skketteiriyuu/SkKetteiRiyuu.do",
               "/sinkeiyaku/sknyuukin/skhurikomisakujyotouroku/SkHurikomiSakujyoTouroku.do",
               "/sinkeiyaku/sknyuukin/sknyuukin/SkNyuukin.do",
               "/sinkeiyaku/sknyuukin/skhenkin/SkHenkin.do?_eventHandler=initHenkinkibou",
               "/sinkeiyaku/sknyuukin/skhenkin/SkHenkin.do",
               "/sinkeiyaku/sknyuukin/sktoujitufbhenkintorikesi/SkToujituFbHenkinTorikesi.do",
               "/sinkeiyaku/sknyuukin/sknyuukinhenkinkakunin/SkNyuukinHenkinKakunin.do",
               "/sinkeiyaku/sknyuukin/skhurikominyuukinhaneiyoyaku/SkHurikomiNyuukinHaneiYoyaku.do",
               "/sinkeiyaku/sknyuukin/sktoujitunyuukintorikesi/SkToujituNyuukinTorikesi.do",
               "/sinkeiyaku/sknyuukin/skcreditjyouhoutouroku/SkCreditJyouhouTouroku.do",
               "/sinkeiyaku/sksonota/skseirituhoryuu/SkSeirituHoryuu.do",
               "/sinkeiyaku/sksonota/sktoujituseiritutorikesi/SkToujituSeirituTorikesi.do",
               "/sinkeiyaku/sksonota/skseikyuusyosakusei/SkSeikyuusyoSakusei.do",
               "/sinkeiyaku/sksonota/sktetudukityuui/SkTetudukiTyuui.do",
               "/sinkeiyaku/sksonota/skmoschkexec/SkMoschkExec.do",
               "/sinkeiyaku/skmaster/skdairitenkobetujyouhoutouroku/SkDairitenKobetuJyouhouTouroku.do",
               "/sinkeiyaku/sksyoukai/skmossyoukai/SkMosSyoukai.do",
               "/sinkeiyaku/sksyoukai/skstyjksyoukai/SkStyjksyoukai.do",
               "/sinkeiyaku/sksyoukai/sktokuteikankeihoujin/SkTokuteiKankeiHoujin.do",
               "/sinkeiyaku/skkyoutuu/sknyuuryokusaisyoukai/SkNyuuryokuSaiSyoukai.do",
               "/sinkeiyaku/skkyoutuu/skhubimsg/SkHubiMsg.do",
               "/hozen/khozen/khjyuusyohenkou/KhJyuusyoHenkou.do",
               "/hozen/khozen/khmeigihenkou/KhMeigiHenkou.do",
               "/hozen/khozen/khkanakanjiteisei/KhKanaKanjiTeisei.do",
               "/hozen/khozen/khsiteidairitokuyakuhuka/KhSiteidairiTokuyakuHuka.do",
               "/hozen/khozen/khkaiyaku/KhKaiyaku.do",
               "/hozen/khozen/khgengaku/KhGengaku.do",
               "/hozen/khozen/khmkhgkhenkou/KhMkhgkHenkou.do",
               "/hozen/khozen/khseinengappiseiteisei/KhSeinengappiSeiTeisei.do",
               "/hozen/khozen/khkaigomaebaraitkhenkou/KhKaigomaebaraiTkHenkou.do",
               "/hozen/khozen/khkeiyakutorikesi/KhKeiyakuTorikesi.do",
               "/hozen/khozen/khtmttkiniten/KhTmttkinIten.do",
               "/hozen/khozen/khyendthnkhrshr/KhYendtHnkHrShr.do",
               "/hozen/khozen/khdshr/KhDShr.do",
               "/hozen/khozen/khkeiyakusyoukai/KhKeiyakuSyoukai.do",
               "/hozen/khozen/khtetudukityuui/KhTetudukiTyuui.do",
               "/hozen/khozen/khyendthnkuktknini/KhYendtHnkUktkNini.do",
               "/hozen/khozen/khmkhgktttyendthnkuktk/KhMkhgkTttYendtHnkUktk.do",
               "/hozen/khozen/khsyoukensaihakkou/KhSyoukenSaihakkou.do",
               "/hozen/khozen/khkoujyosyoumeisaihakkou/KhKoujyosyoumeiSaihakkou.do",
               "/hozen/khozen/khsyouraikaiyakuhenreikin/KhSyouraiKaiyakuhenreikin.do",
               "/hozen/khozen/khkyknaiyouosirase/KhKykNaiyouOsirase.do",
               "/hozen/khozen/khsouhuannaisakusei/KhSouhuannaiSakusei.do",
               "/hozen/khozen/khonlinekensuusyoukai/KhOnlineKensuuSyoukai.do",
               "/hozen/khozen/khtoujituonlinetorikesi/KhToujituOnlineTorikesi.do",
               "/hozen/khozen/khdairiteninfosyuusei/KhDairitenInfoSyuusei.do",
               "/hozen/khozen/khkanikeiyakunaiyouteisei/KhKaniKeiyakuNaiyouTeisei.do",
               "/hozen/khozen/khkawaserateyoteirrtsyoukai/KhKawaseRateYoteiRrtSyoukai.do",
               "/hozen/khozen/khcifcdikkatuhenkoutouroku/KhCifcdIkkatuHenkouTouroku.do",
               "/hozen/khhubikanri/khhubitouroku/KhHubiTouroku.do",
               "/hozen/khozen/khkzktrkkykdrhnk/KhKzktrkKykdrHnk.do",
               "/hozen/khhubikanri/khhubinaiyoukensaku/KhHubiNaiyouKensaku.do",
               "/hozen/khhubikanri/khhubikaisyou/KhHubiKaisyou.do",
               "/hozen/khkessan/khbikinsakujyo/KhBikinSakujyo.do",
               "/hozen/khnayose/khsakuinnmnosyuusei/KhSakuinnmnoSyuusei.do",
               "/hozen/khansyuu/khharaikatahenkou/KhHaraikataHenkou.do",
               "/hozen/khansyuu/khonlinenyuukin/KhOnlineNyuukin.do",
               "/hozen/khansyuu/khnyuukintorikesi/KhNyuukinTorikesi.do",
               "/hozen/khansyuu/khkariuketeisei/KhKariukeTeisei.do",
               "/hozen/khansyuu/khonlinedattai/KhOnlineDattai.do",
               "/hozen/khansyuu/khtokusin/KhTokusin.do",
               "/hozen/khansyuu/khkzseibi/KhKzSeibi.do",
               "/hozen/khansyuu/khzennouseisangksyoukai/KhZennouSeisanGkSyoukai.do",
               "/siharai/simouside/simousideuketuke/SiMousideUketuke.do",
               "/siharai/simouside/sisiboukariuketuke/SiSibouKariUketuke.do",
               "/siharai/simouside/sisiboukariuketuketeisei/SiSibouKariUketukeTeisei.do",
               "/siharai/siskuke/siseikyuuuketukesb/SiSeikyuuUketukeSb.do",
               "/siharai/sisatei/sisateisb/SiSateiSb.do",
               "/siharai/sisatei/sisateisougousyoukai/SiSateiSougouSyoukai.do",
               "/siharai/sisatei/sisyounintorikesi/SiSyouninTorikesi.do",
               "/siharai/sisatei/sisindansyoryousiharai/SiSindansyoryouSiharai.do",
               "/siharai/sisatei/sisinsatyuuisetei/SiSinsaTyuuiSetei.do",
               "/siharai/sisyoukai/sihkkingakusisan/SiHkkingakuSisan.do",
               "/siharai/sisyoukai/sishrrirekisyoukai/SiShrRirekiSyoukai.do",
               "/siharai/sisyoukai/sittzkrirekisyoukai/SiTtzkRirekiSyoukai.do",
               "/siharai/sisyoukai/sibunkatusiharaikeisan/SiBunkatuSiharaiKeisan.do",
               "/siharai/sihubikanri/sihubitouroku/SiHubiTouroku.do",
               "/siharai/sihubikanri/sihubikaisyou/SiHubiKaisyou.do",
               "/siharai/sihubikanri/sihubinaiyoukensaku/SiHubiNaiyouKensaku.do",
               "/siharai/sikessan/sibikintuikasakujyo/SiBikinTuikaSakujyo.do",
               "/siharai/simakefile/simakeseikyuuinfof/SiMakeSeikyuuInfoF.do",
               "/siharai/sisonota/simakesyorui/SiMakeSyorui.do",
               "/direct/dskokyakukanri/dskokyakutouroku/DsKokyakuTouroku.do",
               "/direct/dskokyakukanri/dskokyakuseibi/DsKokyakuSeibi.do",
               "/direct/dssyoukai/dsmailsousinrirekisyoukai/DsMailSousinRirekiSyoukai.do",
               "/direct/dssyoukai/dssousarirekisyoukai/DsSousaRirekiSyoukai.do",
               "/direct/dsmailhaisinkanri/dsmailhaisinyoyaku/DsMailHaisinYoyaku.do",
               "/direct/dskokyakukanri/dstrhkservicetouroku/DsTrhkServiceTouroku.do",
               "/biz/bzkaikei/bzhojyoboruikeigakunyuuryoku/BzHojyoboRuikeigakuNyuuryoku.do"],
  getFeatures :
      function(openUrl) {
        for (var i = 0; i < this.targetUrl.length; i++) {
          if (openUrl !== undefined && openUrl.indexOf(this.targetUrl[i]) >= 0) {
            return this.customFeatures;
          }
        }
        return this.defaultFeatures;
      }
};

var COOKIE_KEY_DUALMODE = "DualMode";
var COOKIE_KEY_WINDOWWIDTH = "ResizeWindowWidth"
var COOKIE_KEY_WINDOWHEIGHT = "ResizeWindowHeight"

var WINDOW_WIDTH = "1160";
var WINDOW_HEIGHT = "688";