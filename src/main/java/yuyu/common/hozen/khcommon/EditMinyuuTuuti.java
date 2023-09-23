package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.util.string.ConvertUtil;
import yuyu.common.base.format.FixedDateFormatter;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzGetBankData;
import yuyu.common.biz.bzcommon.BzGetBankDataBean;
import yuyu.common.biz.bzcommon.BzGetSosikiMadogutiInfo;
import yuyu.common.biz.bzcommon.BzGetSosikiMadogutiInfoKekkaBean;
import yuyu.common.biz.bzcommon.IGkCommonKoumoku;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.classification.C_AsTyouhyoukigouKbn;
import yuyu.def.classification.C_CreditUriageNgJiyuuKbn;
import yuyu.def.classification.C_Dattaikeiro;
import yuyu.def.classification.C_DattairiyuuKbn;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_HurihunoKbn;
import yuyu.def.classification.C_Skszumiflg;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_Yuukoukakkekka;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_Kouza;
import yuyu.def.db.entity.IT_KouzahuriMinyuTuuti;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSya;

import com.google.common.base.Strings;

/**
 * 契約保全 契約保全共通 未入通知編集
 */
public class EditMinyuuTuuti {

    private static final String KBTUUTINM1 = "保険料のお払込みに関する重要なお知らせ";

    private static final String KBTUUTINM2 = "保険料のお払込みに関する重要なお知らせ－消滅予告のご連絡－";

    private static final String KBTUUTINM3 = "保険料振替に関する重要なお知らせ";

    private static final String KBTUUTINM4 = "保険料振替に関する重要なお知らせ　－消滅予告のご連絡－";

    private static final String KBOSIRASEMSGCD1_1 = "いつもお引立てをいただきありがとうございます。";

    private static final String KBOSIRASEMSGCD1_2 = "本通知に記載のご契約につきましては、保険料の口座振替を中止させていただいて";

    private static final String KBOSIRASEMSGCD1_3_1 = "おり、作成日現在、払込期月（";

    private static final String KBOSIRASEMSGCD1_3_2 = "）の保険料のお払込みを確認でき";

    private static final String KBOSIRASEMSGCD1_4 = "ておりません。（保険料払込方法変更をされたときは、右ページの◆をご覧くださ";

    private static final String KBOSIRASEMSGCD1_5 = "い。）";

    private static final String KBOSIRASEMSGCD1_6 = "つきましては、当社までご連絡のうえ、以下【保険料のご案内】に記載の猶予期間";

    private static final String KBOSIRASEMSGCD1_7 = "満了日までに必要な金額をお払い込みくださいますようお願いします。";

    private static final String KBOSIRASEMSGCD1_8 = "";

    private static final String KBOSIRASEMSGCD1_9 = "以下【保険料のご案内】に記載の猶予期間満了日までに保険料のお払込みがない";

    private static final String KBOSIRASEMSGCD1_10 = "ときは、猶予期間満了日の翌日からご契約が消滅します。";

    private static final String KBOSIRASEMSGCD1_11 = "ご契約消滅後に死亡給付金などのお支払理由が発生しても、お支払いすることが";

    private static final String KBOSIRASEMSGCD1_12 = "できませんので、十分にご注意ください。";

    private static final String KBOSIRASEMSGCD2_1 = "いつもお引立てをいただきありがとうございます。";

    private static final String KBOSIRASEMSGCD2_2 = "本通知に記載のご契約につきましては、保険料の口座振替を中止させていただいて";

    private static final String KBOSIRASEMSGCD2_3_1 = "おり、作成日現在、払込期月（";

    private static final String KBOSIRASEMSGCD2_3_2 = "）の保険料のお払込みを確認でき";

    private static final String KBOSIRASEMSGCD2_4 = "ておりません。（解約の手続き中のときは、右ページの◆をご覧ください。）";

    private static final String KBOSIRASEMSGCD2_5 = "つきましては、当社までご連絡のうえ、以下【保険料のご案内】に記載の猶予期間";

    private static final String KBOSIRASEMSGCD2_6 = "満了日までに必要な金額をお払い込みくださいますようお願いします。";

    private static final String KBOSIRASEMSGCD2_7 = "";

    private static final String KBOSIRASEMSGCD2_8 = "以下【保険料のご案内】に記載の猶予期間満了日までに保険料のお払込みがない";

    private static final String KBOSIRASEMSGCD2_9 = "ときは、猶予期間満了日の翌日からご契約が消滅します。";

    private static final String KBOSIRASEMSGCD2_10 = "ご契約消滅後に死亡給付金などのお支払理由が発生しても、お支払いすることが";

    private static final String KBOSIRASEMSGCD2_11 = "できませんので、十分にご注意ください。";

    private static final String KBOSIRASEMSGCD2_12 = "";

    private static final String KBOSIRASEMSGCD3_1 = "いつもお引立てをいただきありがとうございます。";

    private static final String KBOSIRASEMSGCD3_2 = "本通知に記載のご契約につきましては、保険料の口座振替を中止させていただいて";

    private static final String KBOSIRASEMSGCD3_3_1 = "おり、作成日現在、払込期月（";

    private static final String KBOSIRASEMSGCD3_3_2 = "）の保険料のお払込みを確認でき";

    private static final String KBOSIRASEMSGCD3_4 = "ておりません。";

    private static final String KBOSIRASEMSGCD3_5 = "つきましては、当社までご連絡のうえ、以下【保険料のご案内】に記載の猶予期間";

    private static final String KBOSIRASEMSGCD3_6 = "満了日までに必要な金額をお払い込みくださいますようお願いします。";

    private static final String KBOSIRASEMSGCD3_7 = "";

    private static final String KBOSIRASEMSGCD3_8 = "以下【保険料のご案内】に記載の猶予期間満了日までに保険料のお払込みがない";

    private static final String KBOSIRASEMSGCD3_9 = "ときは、猶予期間満了日の翌日からご契約が消滅します。";

    private static final String KBOSIRASEMSGCD3_10 = "ご契約消滅後に死亡給付金などのお支払理由が発生しても、お支払いすることが";

    private static final String KBOSIRASEMSGCD3_11 = "できませんので、十分にご注意ください。";

    private static final String KBOSIRASEMSGCD3_12 = "";

    private static final String KBOSIRASEMSGCD4_1 = "いつもお引立てをいただきありがとうございます。";

    private static final String KBOSIRASEMSGCD4_2 = "本通知に記載のご契約につきましては、保険料の口座振替を中止させていただいて";

    private static final String KBOSIRASEMSGCD4_3_1 = "おり、作成日現在、払込期月（";

    private static final String KBOSIRASEMSGCD4_3_2 = "）の保険料のお払込みを確認でき";

    private static final String KBOSIRASEMSGCD4_4 = "ておりません。（契約内容の変更を手続き中のときは、右ページの◆をご覧くださ";

    private static final String KBOSIRASEMSGCD4_5 = "い。）";

    private static final String KBOSIRASEMSGCD4_6 = "つきましては、当社までご連絡のうえ、以下【保険料のご案内】に記載の猶予期間";

    private static final String KBOSIRASEMSGCD4_7 = "満了日までに必要な金額をお払い込みくださいますようお願いします。";

    private static final String KBOSIRASEMSGCD4_8 = "";

    private static final String KBOSIRASEMSGCD4_9 = "以下【保険料のご案内】に記載の猶予期間満了日までに保険料のお払込みがない";

    private static final String KBOSIRASEMSGCD4_10 = "ときは、猶予期間満了日の翌日からご契約が消滅します。";

    private static final String KBOSIRASEMSGCD4_11 = "ご契約消滅後に死亡給付金などのお支払理由が発生しても、お支払いすることが";

    private static final String KBOSIRASEMSGCD4_12 = "できませんので、十分にご注意ください。";

    private static final String KBOSIRASEMSGCD5_1 = "いつもお引立てをいただきありがとうございます。";

    private static final String KBOSIRASEMSGCD5_2_1 = "本通知に記載のご契約につきましては、払込期月（";

    private static final String KBOSIRASEMSGCD5_2_2 = "）の保険料の";

    private static final String KBOSIRASEMSGCD5_3 = "口座振替ができず、作成日現在、別途のお払込みが確認できておりません。";

    private static final String KBOSIRASEMSGCD5_4_1 = "つきましては、";

    private static final String KBOSIRASEMSGCD5_4_2 = "は以下【保険料のご案内】に記載のとおり口座から振り替え";

    private static final String KBOSIRASEMSGCD5_5_1 = "させていただきますので、";

    private static final String KBOSIRASEMSGCD5_5_2 = "までに必要な金額を振替口座に";

    private static final String KBOSIRASEMSGCD5_6 = "ご準備くださいますようお願いします。";

    private static final String KBOSIRASEMSGCD5_7 = "";

    private static final String KBOSIRASEMSGCD5_8 = "以下【保険料のご案内】に記載の猶予期間満了日までに口座から振り替えできず";

    private static final String KBOSIRASEMSGCD5_9 = "別途保険料のお払込みもない場合は、猶予期間満了日の翌日からご契約が消滅しま";

    private static final String KBOSIRASEMSGCD5_10 = "す。ご契約消滅後に死亡給付金などのお支払理由が発生しても、お支払いすること";

    private static final String KBOSIRASEMSGCD5_11 = "ができませんので、十分にご注意ください。";

    private static final String KBOSIRASEMSGCD5_12 = "";

    private static final String KBPANNAINM = "【保険料のご案内】";

    private static final String KBNEXTHURIKAEMAIYOU1_1 = "お払込みのない保険料";

    private static final String KBNEXTHURIKAEMAIYOU1_2_1 = "　　";

    private static final String KBNEXTHURIKAEMAIYOU1_2_2 = "円（";

    private static final String KBNEXTHURIKAEMAIYOU1_2_3 = "から";

    private static final String KBNEXTHURIKAEMAIYOU1_2_4 = "か月分の保険料）";

    private static final String KBNEXTHURIKAEMAIYOU1_3 = "";

    private static final String KBNEXTHURIKAEMAIYOU2_1 = "次回振替内容";

    private static final String KBNEXTHURIKAEMAIYOU2_2_1 = "の口座振替金額　　　　　　　　　　【振替日　";

    private static final String KBNEXTHURIKAEMAIYOU2_2_2 = "】";

    private static final String KBNEXTHURIKAEMAIYOU2_3_1 = "　　";

    private static final String KBNEXTHURIKAEMAIYOU2_3_2 = "円（";

    private static final String KBNEXTHURIKAEMAIYOU2_3_3 = "から";

    private static final String KBNEXTHURIKAEMAIYOU2_3_4 = "か月分の保険料）";

    private static final String KBSAIKOKUKIYYKKN1 = "分の保険料の猶予期間満了日";

    private static final String KBSAIKOKUKIYYKKN2 = "　　";

    private static final String KBHRKMIRMSG1_1 = "　＊振替日（";

    private static final String KBHRKMIRMSG1_2 = "）に振替口座から振り替えできない場合は、";

    private static final String KBHRKMIRMSG2_1 = "　　猶予期間満了日（";

    private static final String KBHRKMIRMSG2_2 = "）までに当社までご連絡のうえ、";

    private static final String KBHRKMIRMSG3 = "　　必要な金額をお払い込みください。";

    private static final String KBZENHURIKAENAIYOU2_1 = "＜ご参考情報＞";

    private static final String KBZENHURIKAENAIYOU2_2_1 = "の口座振替結果　　　　　　　　　　【振替日　";

    private static final String KBZENHURIKAENAIYOU2_2_2 = "】";

    private static final String KBZENHURIKAENAIYOU2_3_1 = "　　";

    private static final String KBZENHURIKAENAIYOU2_3_2 = "から";

    private static final String KBZENHURIKAENAIYOU2_3_3 = "か月分の保険料";

    private static final String KBZENHURIKAENAIYOU2_3_4 = "円は";

    private static final String KBZENHURIKAENAIYOU2_4 = "　　口座振替できませんでした。";

    private static final String KBZENHURIKAENAIYOU3_1 = "＜ご参考情報＞";

    private static final String KBZENHURIKAENAIYOU3_2_1 = "の口座振替結果　　　　　　　　　　【振替日　";

    private static final String KBZENHURIKAENAIYOU3_2_2 = "】";

    private static final String KBZENHURIKAENAIYOU3_3_1 = "　　";

    private static final String KBZENHURIKAENAIYOU3_3_2 = "から";

    private static final String KBZENHURIKAENAIYOU3_3_3 = "か月分の保険料";

    private static final String KBZENHURIKAENAIYOU3_3_4 = "円は";

    private static final String KBZENHURIKAENAIYOU3_4 = "　　預金不足のため口座振替できませんでした。";

    private static final String KBZENHURIKAENAIYOU4_1 = "＜ご参考情報＞";

    private static final String KBZENHURIKAENAIYOU4_2_1 = "の口座振替結果　　　　　　　　　　【振替日　";

    private static final String KBZENHURIKAENAIYOU4_2_2 = "】";

    private static final String KBZENHURIKAENAIYOU4_3_1 = "　　";

    private static final String KBZENHURIKAENAIYOU4_3_2 = "から";

    private static final String KBZENHURIKAENAIYOU4_3_3 = "か月分の保険料";

    private static final String KBZENHURIKAENAIYOU4_3_4 = "円は";

    private static final String KBZENHURIKAENAIYOU4_4 = "　　お申し出により口座振替できませんでした。";

    private static final String KBHURIKAEKZ1_1 = "振替口座（ご指定の金融機関・口座）";

    private static final String KBHURIKAEKZ1_4 = "通帳番号　";

    private static final String KBHURIKAEKZ1_5_1 = "口座名義人　";

    private static final String KBHURIKAEKZ1_5_2 = "様";

    private static final String KBHURIKAEKZ1_6 = "＊お客さま情報保護のため、通帳番号の一部を＊にて表示しています。";

    private static final String KBHURIKAEKZ2_1 = "振替口座（ご指定の金融機関・口座）";

    private static final String KBHURIKAEKZ2_4_2 = "　　口座番号　";

    private static final String KBHURIKAEKZ2_5_1 = "口座名義人　";

    private static final String KBHURIKAEKZ2_5_2 = "様";

    private static final String KBHURIKAEKZ2_6 = "＊お客さま情報保護のため、口座番号の一部を＊にて表示しています。";

    private static final String KBMINYUTTADDMSG1_1 = "";

    private static final String KBMINYUTTADDMSG1_2 = "＊払込期月とは、各保険料をお払い込みいただく期限のことをいいます。";

    private static final String KBMINYUTTADDMSG1_3 = "　（各保険料について、お払い込みいただく月の初日から末日までの１か月と";

    private static final String KBMINYUTTADDMSG1_4 = "　なります。）";

    private static final String KBMINYUTTADDMSG1_5 = "";

    private static final String KBMINYUTTADDMSG1_6 = "＊本通知は、払込期月内の保険料のお払込みを確認できていないご契約者さまに";

    private static final String KBMINYUTTADDMSG1_7 = "　お送りしています。（左記【保険料のご案内】に記載の猶予期間満了日までに";

    private static final String KBMINYUTTADDMSG1_8 = "　お払い込みいただければ、ご契約は有効に継続します。）";

    private static final String KBMINYUTTADDMSG1_9 = "";

    private static final String KBMINYUTTADDMSG1_10 = "＊本通知と行き違いに保険料をお払い込みいただいている場合は、あしからず";

    private static final String KBMINYUTTADDMSG1_11 = "　ご了承くださいますようお願いします。";

    private static final String KBMINYUTTADDMSG1_12 = "";

    private static final String KBMINYUTTADDMSG1_13 = "＊当社職員から電話等でご連絡させていただくことがあります。";

    private static final String KBMINYUTTADDMSG1_14 = "";

    private static final String KBMINYUTTADDMSG1_15 = "＊予定利率変動型５年ごと利差配当付指定通貨建個人年金保険は、円貨払込額";

    private static final String KBMINYUTTADDMSG1_18 = "";

    private static final String KBMINYUTTADDMSG1_19 = "";

    private static final String KBMINYUTTADDMSG1_20 = "";

    private static final String KBMINYUTTADDMSG1_21 = "";

    private static final String KBMINYUTTADDMSG2_1 = "";

    private static final String KBMINYUTTADDMSG2_2 = "＊払込期月とは、各保険料をお払い込みいただく期限のことをいいます。";

    private static final String KBMINYUTTADDMSG2_3 = "　（各保険料について、お払い込みいただく月の初日から末日までの１か月と";

    private static final String KBMINYUTTADDMSG2_4 = "　なります。）";

    private static final String KBMINYUTTADDMSG2_5 = "＊本通知は、払込期月内の保険料のお払込みを確認できていないご契約者さまに";

    private static final String KBMINYUTTADDMSG2_6 = "　お送りしています。（左記【保険料のご案内】に記載の猶予期間満了日までに";

    private static final String KBMINYUTTADDMSG2_7 = "　お払い込みいただければ、ご契約は有効に継続します。）";

    private static final String KBMINYUTTADDMSG2_8 = "＊本通知と行き違いに保険料をお払い込みいただいている場合は、あしからず";

    private static final String KBMINYUTTADDMSG2_9 = "　ご了承くださいますようお願いします。";

    private static final String KBMINYUTTADDMSG2_10 = "";

    private static final String KBMINYUTTADDMSG2_11 = "＊ご契約が消滅した場合、消滅日（※）を換算基準日として解約返戻金を円貨換算";

    private static final String KBMINYUTTADDMSG2_12 = "　し、お支払いします。この場合、原則として、上記振替口座に自動的に送金しま";

    private static final String KBMINYUTTADDMSG2_13 = "　す。";

    private static final String KBMINYUTTADDMSG2_14 = "　※消滅日が、当社が指標として指定する金融機関の休業日の場合は、消滅日の";

    private static final String KBMINYUTTADDMSG2_15 = "　直後に到来するその金融機関の営業日を換算基準日とします。";

    private static final String KBMINYUTTADDMSG2_16 = "";

    private static final String KBMINYUTTADDMSG2_17 = "＊当社職員から電話等でご連絡させていただくことがあります。";

    private static final String KBMINYUTTADDMSG2_18 = "";

    private static final String KBMINYUTTADDMSG2_19 = "＊予定利率変動型５年ごと利差配当付指定通貨建個人年金保険は、円貨払込額";

    private static final String KBMINYUTTADDMSG3_1 = "";

    private static final String KBMINYUTTADDMSG3_2 = "＊払込期月とは、各保険料をお払い込みいただく期限のことをいいます。";

    private static final String KBMINYUTTADDMSG3_3 = "　（各保険料について、お払い込みいただく月の初日から末日までの１か月と";

    private static final String KBMINYUTTADDMSG3_4 = "　なります。）";

    private static final String KBMINYUTTADDMSG3_5 = "";

    private static final String KBMINYUTTADDMSG3_6 = "＊本通知と行き違いに保険料をお払い込みいただいているときは、あしからず";

    private static final String KBMINYUTTADDMSG3_7 = "　ご了承くださいますようお願いします。";

    private static final String KBMINYUTTADDMSG3_8 = "";

    private static final String KBMINYUTTADDMSG3_9 = "◆保険料払込方法変更をされたお客さまへ";

    private static final String KBMINYUTTADDMSG3_10 = "　ご契約の効力に関する重要なお知らせにつき、保険料払込方法変更の手続き";

    private static final String KBMINYUTTADDMSG3_11 = "　により保険料の引去りを中止したご契約につきましても、本通知を送付しており";

    private static final String KBMINYUTTADDMSG3_12 = "　ます。あしからずご了承ください。";

    private static final String KBMINYUTTADDMSG3_13 = "";

    private static final String KBMINYUTTADDMSG3_14 = "＊予定利率変動型５年ごと利差配当付指定通貨建個人年金保険は、円貨払込額";

    private static final String KBMINYUTTADDMSG3_17 = "";

    private static final String KBMINYUTTADDMSG3_18 = "";

    private static final String KBMINYUTTADDMSG3_19 = "";

    private static final String KBMINYUTTADDMSG3_20 = "";

    private static final String KBMINYUTTADDMSG3_21 = "";

    private static final String KBMINYUTTADDMSG4_1 = "";

    private static final String KBMINYUTTADDMSG4_2 = "＊払込期月とは、各保険料をお払い込みいただく期限のことをいいます。";

    private static final String KBMINYUTTADDMSG4_3 = "　（各保険料について、お払い込みいただく月の初日から末日までの１か月と";

    private static final String KBMINYUTTADDMSG4_4 = "　なります。）";

    private static final String KBMINYUTTADDMSG4_5 = "＊本通知と行き違いに保険料をお払い込みいただいているときは、あしからず";

    private static final String KBMINYUTTADDMSG4_6 = "　ご了承くださいますようお願いします。";

    private static final String KBMINYUTTADDMSG4_7 = "";

    private static final String KBMINYUTTADDMSG4_8 = "＊ご契約が消滅した場合、消滅日（※）を換算基準日として解約返戻金を円貨換算";

    private static final String KBMINYUTTADDMSG4_9 = "　し、お支払いします。この場合、原則として、上記振替口座に自動的に送金しま";

    private static final String KBMINYUTTADDMSG4_10 = "　す。";

    private static final String KBMINYUTTADDMSG4_11 = "　※消滅日が、当社が指標として指定する金融機関の休業日の場合は、消滅日の";

    private static final String KBMINYUTTADDMSG4_12 = "　直後に到来するその金融機関の営業日を換算基準日とします。";

    private static final String KBMINYUTTADDMSG4_13 = "";

    private static final String KBMINYUTTADDMSG4_14 = "◆保険料払込方法変更をされたお客さまへ";

    private static final String KBMINYUTTADDMSG4_15 = "　ご契約の効力に関する重要なお知らせにつき、保険料払込方法変更の手続き";

    private static final String KBMINYUTTADDMSG4_16 = "　により保険料の引去りを停止したご契約につきましても、本通知を送付しており";

    private static final String KBMINYUTTADDMSG4_17 = "　ます。あしからずご了承ください。";

    private static final String KBMINYUTTADDMSG4_18 = "";

    private static final String KBMINYUTTADDMSG4_19 = "＊予定利率変動型５年ごと利差配当付指定通貨建個人年金保険は、円貨払込額";

    private static final String KBMINYUTTADDMSG5_1 = "";

    private static final String KBMINYUTTADDMSG5_2 = "＊払込期月とは、各保険料をお払い込みいただく期限のことをいいます。";

    private static final String KBMINYUTTADDMSG5_3 = "　（各保険料について、お払い込みいただく月の初日から末日までの１か月と";

    private static final String KBMINYUTTADDMSG5_4 = "　なります。）";

    private static final String KBMINYUTTADDMSG5_5 = "";

    private static final String KBMINYUTTADDMSG5_6 = "＊本通知と行き違いに保険料をお払い込みいただいているときは、あしからず";

    private static final String KBMINYUTTADDMSG5_7 = "　ご了承くださいますようお願いします。";

    private static final String KBMINYUTTADDMSG5_8 = "";

    private static final String KBMINYUTTADDMSG5_9 = "◆解約の手続き中のお客さまへ";

    private static final String KBMINYUTTADDMSG5_10 = "　解約の手続きを承っているご契約につきましても、猶予期間内の保険料のお払込";

    private static final String KBMINYUTTADDMSG5_11 = "　みがないときはご契約が消滅することをお知らせするために本通知を送付して";

    private static final String KBMINYUTTADDMSG5_12 = "　おります。あしからずご了承ください。";

    private static final String KBMINYUTTADDMSG5_13 = "";

    private static final String KBMINYUTTADDMSG5_14 = "＊予定利率変動型５年ごと利差配当付指定通貨建個人年金保険は、円貨払込額";

    private static final String KBMINYUTTADDMSG5_17 = "";

    private static final String KBMINYUTTADDMSG5_18 = "";

    private static final String KBMINYUTTADDMSG5_19 = "";

    private static final String KBMINYUTTADDMSG5_20 = "";

    private static final String KBMINYUTTADDMSG5_21 = "";

    private static final String KBMINYUTTADDMSG6_1 = "";

    private static final String KBMINYUTTADDMSG6_2 = "＊払込期月とは、各保険料をお払い込みいただく期限のことをいいます。";

    private static final String KBMINYUTTADDMSG6_3 = "　（各保険料について、お払い込みいただく月の初日から末日までの１か月と";

    private static final String KBMINYUTTADDMSG6_4 = "　なります。）";

    private static final String KBMINYUTTADDMSG6_5 = "＊本通知と行き違いに保険料をお払い込みいただいているときは、あしからず";

    private static final String KBMINYUTTADDMSG6_6 = "　ご了承くださいますようお願いします。";

    private static final String KBMINYUTTADDMSG6_7 = "";

    private static final String KBMINYUTTADDMSG6_8 = "＊ご契約が消滅した場合、消滅日（※）を換算基準日として解約返戻金を円貨換算";

    private static final String KBMINYUTTADDMSG6_9 = "　し、お支払いします。この場合、原則として、上記振替口座に自動的に送金しま";

    private static final String KBMINYUTTADDMSG6_10 = "　す。";

    private static final String KBMINYUTTADDMSG6_11 = "　※消滅日が、当社が指標として指定する金融機関の休業日の場合は、消滅日の";

    private static final String KBMINYUTTADDMSG6_12 = "　直後に到来するその金融機関の営業日を換算基準日とします。";

    private static final String KBMINYUTTADDMSG6_13 = "";

    private static final String KBMINYUTTADDMSG6_14 = "◆解約の手続き中のお客さまへ";

    private static final String KBMINYUTTADDMSG6_15 = "　解約の手続きを承っているご契約につきましても、猶予期間内の保険料のお払込";

    private static final String KBMINYUTTADDMSG6_16 = "　みがないときはご契約が消滅することをお知らせするために本通知を送付して";

    private static final String KBMINYUTTADDMSG6_17 = "　おります。あしからずご了承ください。";

    private static final String KBMINYUTTADDMSG6_18 = "";

    private static final String KBMINYUTTADDMSG6_19 = "＊予定利率変動型５年ごと利差配当付指定通貨建個人年金保険は、円貨払込額";

    private static final String KBMINYUTTADDMSG7_1 = "";

    private static final String KBMINYUTTADDMSG7_2 = "＊払込期月とは、各保険料をお払い込みいただく期限のことをいいます。";

    private static final String KBMINYUTTADDMSG7_3 = "　（各保険料について、お払い込みいただく月の初日から末日までの１か月と";

    private static final String KBMINYUTTADDMSG7_4 = "　なります。）";

    private static final String KBMINYUTTADDMSG7_5 = "";

    private static final String KBMINYUTTADDMSG7_6 = "＊本通知と行き違いに保険料をお払い込みいただいているときは、あしからず";

    private static final String KBMINYUTTADDMSG7_7 = "　ご了承くださいますようお願いします。";

    private static final String KBMINYUTTADDMSG7_8 = "";

    private static final String KBMINYUTTADDMSG7_9 = "◆契約内容の変更を手続き中のお客さまへ";

    private static final String KBMINYUTTADDMSG7_10 = "　ご契約の効力に関する重要なお知らせにつき、契約内容の変更の手続きを承って";

    private static final String KBMINYUTTADDMSG7_11 = "　いるご契約につきましても、本通知を送付しております。あしからず、ご了承";

    private static final String KBMINYUTTADDMSG7_12 = "　ください。";

    private static final String KBMINYUTTADDMSG7_13 = "";

    private static final String KBMINYUTTADDMSG7_14 = "＊予定利率変動型５年ごと利差配当付指定通貨建個人年金保険は、円貨払込額";

    private static final String KBMINYUTTADDMSG7_17 = "";

    private static final String KBMINYUTTADDMSG7_18 = "";

    private static final String KBMINYUTTADDMSG7_19 = "";

    private static final String KBMINYUTTADDMSG7_20 = "";

    private static final String KBMINYUTTADDMSG7_21 = "";

    private static final String KBMINYUTTADDMSG8_1 = "";

    private static final String KBMINYUTTADDMSG8_2 = "＊払込期月とは、各保険料をお払い込みいただく期限のことをいいます。";

    private static final String KBMINYUTTADDMSG8_3 = "　（各保険料について、お払い込みいただく月の初日から末日までの１か月と";

    private static final String KBMINYUTTADDMSG8_4 = "　なります。）";

    private static final String KBMINYUTTADDMSG8_5 = "＊本通知と行き違いに保険料をお払い込みいただいているときは、あしからず";

    private static final String KBMINYUTTADDMSG8_6 = "　ご了承くださいますようお願いします。";

    private static final String KBMINYUTTADDMSG8_7 = "";

    private static final String KBMINYUTTADDMSG8_8 = "＊ご契約が消滅した場合、消滅日（※）を換算基準日として解約返戻金を円貨換算";

    private static final String KBMINYUTTADDMSG8_9 = "　し、お支払いします。この場合、原則として、上記振替口座に自動的に送金しま";

    private static final String KBMINYUTTADDMSG8_10 = "　す。";

    private static final String KBMINYUTTADDMSG8_11 = "　※消滅日が、当社が指標として指定する金融機関の休業日の場合は、消滅日の";

    private static final String KBMINYUTTADDMSG8_12 = "　直後に到来するその金融機関の営業日を換算基準日とします。";

    private static final String KBMINYUTTADDMSG8_13 = "";

    private static final String KBMINYUTTADDMSG8_14 = "◆契約内容の変更を手続き中のお客さまへ";

    private static final String KBMINYUTTADDMSG8_15 = "　ご契約の効力に関する重要なお知らせにつき、契約内容の変更の手続きを承って";

    private static final String KBMINYUTTADDMSG8_16 = "　いるご契約につきましても、本通知を送付しております。あしからず、ご了承";

    private static final String KBMINYUTTADDMSG8_17 = "　ください。";

    private static final String KBMINYUTTADDMSG8_18 = "";

    private static final String KBMINYUTTADDMSG8_19 = "＊予定利率変動型５年ごと利差配当付指定通貨建個人年金保険は、円貨払込額";

    private static final String KBMINYUTTADDMSG9_1 = "";

    private static final String KBMINYUTTADDMSG9_2 = "＊払込期月とは、各保険料をお払い込みいただく期限のことをいいます。";

    private static final String KBMINYUTTADDMSG9_3 = "　（各保険料について、お払い込みいただく月の初日から末日までの１か月と";

    private static final String KBMINYUTTADDMSG9_4 = "　なります。）";

    private static final String KBMINYUTTADDMSG9_5 = "";

    private static final String KBMINYUTTADDMSG9_6 = "＊本通知は、払込期月内の保険料のお払込みを確認できていないご契約者さまに";

    private static final String KBMINYUTTADDMSG9_7 = "　お送りしています。（左記【保険料のご案内】に記載の猶予期間満了日までに";

    private static final String KBMINYUTTADDMSG9_8 = "　お払い込みいただければ、ご契約は有効に継続します。）";

    private static final String KBMINYUTTADDMSG9_9 = "";

    private static final String KBMINYUTTADDMSG9_10 = "＊本通知と行き違いに保険料をお払い込みいただいている場合は、あしからず";

    private static final String KBMINYUTTADDMSG9_11 = "　ご了承くださいますようお願いします。";

    private static final String KBMINYUTTADDMSG9_12 = "";

    private static final String KBMINYUTTADDMSG9_13 = "＊当社職員から電話等でご連絡させていただくことがあります。";

    private static final String KBMINYUTTADDMSG9_14 = "";

    private static final String KBMINYUTTADDMSG9_15 = "＊予定利率変動型５年ごと利差配当付指定通貨建個人年金保険は、円貨払込額";

    private static final String KBMINYUTTADDMSG9_18 = "";

    private static final String KBMINYUTTADDMSG9_19 = "";

    private static final String KBMINYUTTADDMSG9_20 = "";

    private static final String KBMINYUTTADDMSG9_21 = "";

    private static final String KBMINYUTTADDMSG10_1 = "";

    private static final String KBMINYUTTADDMSG10_2 = "＊払込期月とは、各保険料をお払い込みいただく期限のことをいいます。";

    private static final String KBMINYUTTADDMSG10_3 = "　（各保険料について、お払い込みいただく月の初日から末日までの１か月と";

    private static final String KBMINYUTTADDMSG10_4 = "　なります。）";

    private static final String KBMINYUTTADDMSG10_5 = "＊本通知は、払込期月内の保険料のお払込みを確認できていないご契約者さまに";

    private static final String KBMINYUTTADDMSG10_6 = "　お送りしています。（左記【保険料のご案内】に記載の猶予期間満了日までに";

    private static final String KBMINYUTTADDMSG10_7 = "　お払い込みいただければ、ご契約は有効に継続します。）";

    private static final String KBMINYUTTADDMSG10_8 = "＊本通知と行き違いに保険料をお払い込みいただいている場合は、あしからず";

    private static final String KBMINYUTTADDMSG10_9 = "　ご了承くださいますようお願いします。";

    private static final String KBMINYUTTADDMSG10_10 = "";

    private static final String KBMINYUTTADDMSG10_11 = "＊当社職員から電話等でご連絡させていただくことがあります。";

    private static final String KBMINYUTTADDMSG10_12 = "";

    private static final String KBMINYUTTADDMSG10_13 = "＊ご契約が消滅した場合、消滅日（※）を換算基準日として解約返戻金を円貨換算";

    private static final String KBMINYUTTADDMSG10_14 = "　し、お支払いします。この場合、原則として、上記振替口座に自動的に送金しま";

    private static final String KBMINYUTTADDMSG10_15 = "　す。";

    private static final String KBMINYUTTADDMSG10_16 = "　※消滅日が、当社が指標として指定する金融機関の休業日の場合は、消滅日の";

    private static final String KBMINYUTTADDMSG10_17 = "　直後に到来するその金融機関の営業日を換算基準日とします。";

    private static final String KBMINYUTTADDMSG10_18 = "";

    private static final String KBMINYUTTADDMSG10_19 = "＊予定利率変動型５年ごと利差配当付指定通貨建個人年金保険は、円貨払込額";

    private static final String KBMINYUTTADDMSG11_1 = "";

    private static final String KBMINYUTTADDMSG11_2 = "＊払込期月とは、各保険料をお払い込みいただく期限のことをいいます。";

    private static final String KBMINYUTTADDMSG11_3 = "　（各保険料について、お払い込みいただく月の初日から末日までの１か月と";

    private static final String KBMINYUTTADDMSG11_4 = "　なります。）";

    private static final String KBMINYUTTADDMSG11_5 = "";

    private static final String KBMINYUTTADDMSG11_6 = "＊本通知は、払込期月内の保険料のお払込みを確認できていないご契約者さまに";

    private static final String KBMINYUTTADDMSG11_7 = "　お送りしています。（左記【保険料のご案内】に記載の猶予期間満了日までに";

    private static final String KBMINYUTTADDMSG11_8 = "　お払い込みいただければ、ご契約は有効に継続します。）";

    private static final String KBMINYUTTADDMSG11_9 = "";

    private static final String KBMINYUTTADDMSG11_10 = "＊本通知と行き違いに保険料をお払い込みいただいている場合は、あしからず";

    private static final String KBMINYUTTADDMSG11_11 = "　ご了承くださいますようお願いします。";

    private static final String KBMINYUTTADDMSG11_12 = "";

    private static final String KBMINYUTTADDMSG11_13 = "＊別途『口座振替中止のお知らせ』をお送りしている場合がありますので、";

    private static final String KBMINYUTTADDMSG11_14 = "　あわせてご確認ください。";

    private static final String KBMINYUTTADDMSG11_15 = "";

    private static final String KBMINYUTTADDMSG11_16 = "＊当社職員から電話等でご連絡させていただくことがあります。";

    private static final String KBMINYUTTADDMSG11_17 = "";

    private static final String KBMINYUTTADDMSG11_18 = "＊予定利率変動型５年ごと利差配当付指定通貨建個人年金保険は、円貨払込額";

    private static final String KBMINYUTTADDMSG11_21 = "";

    private static final String KBMINYUTTADDMSG12_1 = "＊払込期月とは、各保険料をお払い込みいただく期限のことをいいます。";

    private static final String KBMINYUTTADDMSG12_2 = "　（各保険料について、お払い込みいただく月の初日から末日までの１か月と";

    private static final String KBMINYUTTADDMSG12_3 = "　なります。）";

    private static final String KBMINYUTTADDMSG12_4 = "＊本通知は、払込期月内の保険料のお払込みを確認できていないご契約者さまに";

    private static final String KBMINYUTTADDMSG12_5 = "　お送りしています。（左記【保険料のご案内】に記載の猶予期間満了日までに";

    private static final String KBMINYUTTADDMSG12_6 = "　お払い込みいただければ、ご契約は有効に継続します。）";

    private static final String KBMINYUTTADDMSG12_7 = "＊本通知と行き違いに保険料をお払い込みいただいている場合は、あしからず";

    private static final String KBMINYUTTADDMSG12_8 = "　ご了承くださいますようお願いします。";

    private static final String KBMINYUTTADDMSG12_9 = "";

    private static final String KBMINYUTTADDMSG12_10 = "＊別途『口座振替中止のお知らせ』をお送りしている場合がありますので、";

    private static final String KBMINYUTTADDMSG12_11 = "　あわせてご確認ください。";

    private static final String KBMINYUTTADDMSG12_12 = "＊当社職員から電話等でご連絡させていただくことがあります。";

    private static final String KBMINYUTTADDMSG12_13 = "";

    private static final String KBMINYUTTADDMSG12_14 = "＊ご契約が消滅した場合、消滅日（※）を換算基準日として解約返戻金を円貨換算";

    private static final String KBMINYUTTADDMSG12_15 = "　し、お支払いします。この場合、原則として、上記振替口座に自動的に送金しま";

    private static final String KBMINYUTTADDMSG12_16 = "　す。";

    private static final String KBMINYUTTADDMSG12_17 = "　※消滅日が、当社が指標として指定する金融機関の休業日の場合は、消滅日の";

    private static final String KBMINYUTTADDMSG12_18 = "　直後に到来するその金融機関の営業日を換算基準日とします。";

    private static final String KBMINYUTTADDMSG12_19 = "＊予定利率変動型５年ごと利差配当付指定通貨建個人年金保険は、円貨払込額";

    private static final String KBOSIRASEMSG_HRKKIGEN_1 = "つきましては、当社までご連絡のうえ、以下【保険料のご案内】に記載の払込期限";

    private static final String KBOSIRASEMSG_HRKKIGEN_2 = "日までに必要な金額をお払い込みくださいますようお願いします。";

    private static final String KBOSIRASEMSG_HRKKIGEN_3 = "以下【保険料のご案内】に記載の払込期限日までに保険料のお払込みがない";

    private static final String KBOSIRASEMSG_HRKKIGEN_4 = "ときは、猶予期間満了日の翌日からご契約が消滅します。";

    private static final String KBOSIRASEMSG_HRKKIGEN_5 = "以下【保険料のご案内】に記載の払込期限日までに口座から振り替えできず";

    private static final String KBSAIKOKUKIYYKKN_HRKKIGEN_1 = "分の保険料の払込期限日";

    private static final String KBHRKMIRMSG_HRKKIGEN_1 = "　　払込期限日（";

    private static final String KBADDMSG_HRKKIGEN_1 = "＊払込期月とは、各保険料をお払い込みいただく月の初日から末日までの１か月の";

    private static final String KBADDMSG_HRKKIGEN_2 = "　ことをいいます。";

    private static final String KBADDMSG_HRKKIGEN_3 = "　お送りしています。（左記【保険料のご案内】に記載の払込期限日までにお払";

    private static final String KBADDMSG_HRKKIGEN_4 = "　い込みいただければ、ご契約は有効に継続します。）";

    private static final String KBADDMSG_HRKKIGEN_5 = "　解約の手続きを承っているご契約につきましても、払込期限日までに保険料の";

    private static final String KBADDMSG_HRKKIGEN_6 = "　お払込みがないときはご契約が消滅することをお知らせするために本通知を送付";

    private static final String KBADDMSG_HRKKIGEN_7 = "　しております。あしからずご了承ください。";

    private static final String KBADDMSG_TIKIKTBRI_1 = "　（定期一括払いの場合は、定期一括払円貨払込額）について「保険料」と表示し";

    private static final String KBADDMSG_TIKIKTBRI_2 = "　ております。";

    private static final String KB_BLANK = "";

    private static final String KBCREDITOSIRASEMSG_COMMON_1 = "いつもお引立てをいただきありがとうございます。";

    private static final String KBCREDITOSIRASEMSG_COMMON_2 = "本通知に記載のご契約につきましては、";

    private static final String KBCREDITOSIRASEMSG_COMMON_3 = "ご契約消滅後に死亡給付金などのお支払理由が発生しても、お支払いすることがで";

    private static final String KBCREDITOSIRASEMSG_COMMON_4 = "きませんので、十分にご注意ください。";

    private static final String KBCREDITOSIRASEMSG_GNDGK_2 = "クレジットカードのご利用額が限度額を超";

    private static final String KBCREDITOSIRASEMSG1_GNDGK3_1 = "過しており、作成日現在、払込期月（";

    private static final String KBCREDITOSIRASEMSG1_GNDGK3_2 = "）の保険料のお払込みを確";

    private static final String KBCREDITOSIRASEMSG1_GNDGK_4 = "認できておりません。";

    private static final String KBCREDITOSIRASEMSG1_GNDGK5_1 = "つきましては、次回のカードご利用日（";

    private static final String KBCREDITOSIRASEMSG1_GNDGK5_2 = "）に以下【保険料";

    private static final String KBCREDITOSIRASEMSG1_GNDGK_6 = "のご案内】に記載のとおりクレジットカードにて決済させていただきます。";

    private static final String KBCREDITOSIRASEMSG1_GNDGK_7 = "次回のカードご利用日に保険料をクレジットカードにて決済できず、以下【保険料";

    private static final String KBCREDITOSIRASEMSG1_GNDGK_8_YUUYO = "のご案内】に記載の猶予期間満了日までに保険料のお払込みもないときは、猶予期";

    private static final String KBCREDITOSIRASEMSG1_GNDGK_9_YUUYO = "間満了日の翌日からご契約が消滅します。";

    private static final String KBCREDITOSIRASEMSG1_GNDGK_8_HRK = "のご案内】に記載の払込期限日までに保険料のお払込みもないときは、猶予期間満";

    private static final String KBCREDITOSIRASEMSG1_GNDGK_9_HRK = "了日の翌日からご契約が消滅します。";

    private static final String KBCREDITOSIRASEMSG2_YUUKSNG_2 = "ご登録のクレジットカードがご利用いただ";

    private static final String KBCREDITOSIRASEMSG2_YUUKSNG_3 = "けないため、クレジットカードの変更手続きをご案内しておりましたが、本通知の";

    private static final String KBCREDITOSIRASEMSG2_YUUKSNG_4 = "作成日現在、変更手続きが完了しておりません。そのため、払込期月（";

    private static final String KBCREDITOSIRASEMSG2_YUUKSNG_5 = "）の保険料をお払い込みいただけておりません。";

    private static final String KBCREDITOSIRASEMSG2_YUUKSNG_6_YUUYO = "つきましては、以下【保険料のご案内】に記載の猶予期間満了日までに、クレジッ";

    private static final String KBCREDITOSIRASEMSG2_YUUKSNG_7_YUUYO = "トカードの変更手続き書類を当社に到着するようご返送ください。";

    private static final String KBCREDITOSIRASEMSG2_YUUKSNG_8_YUUYO = "以下【保険料のご案内】に記載の猶予期間満了日までに変更手続き書類をご返送い";

    private static final String KBCREDITOSIRASEMSG2_YUUKSNG_9_YUUYO = "ただけないときは、保険料をお払い込みいただけないため猶予期間満了日の翌日か";

    private static final String KBCREDITOSIRASEMSG2_YUUKSNG_10_YUUYO = "らご契約が消滅します。";

    private static final String KBCREDITOSIRASEMSG2_YUUKSNG_6_HRK = "つきましては、以下【保険料のご案内】に記載の払込期限日までに、クレジット";

    private static final String KBCREDITOSIRASEMSG2_YUUKSNG_7_HRK = "カードの変更手続き書類を当社に到着するようご返送ください。";

    private static final String KBCREDITOSIRASEMSG2_YUUKSNG_8_HRK = "なお、払込期限日までに変更手続き書類をご返送いただけないときは、保険料をお";

    private static final String KBCREDITOSIRASEMSG2_YUUKSNG_9_HRK = "払い込みいただけないため猶予期間満了日の翌日からご契約が消滅します。";

    private static final String KBCREDITOSIRASEMSG_DATTAITYU_2 = "保険料の請求を中止させていただいており";

    private static final String KBCREDITOSIRASEMSG_DATTAITYU_3_1 = "作成日現在、払込期月（";

    private static final String KBCREDITOSIRASEMSG_DATTAITYU_3_2 = "）の保険料のお払込みを確認できており";

    private static final String KBCREDITOSIRASEMSG_DATTAITYU_4_1 = "ません。";

    private static final String KBCREDITOSIRASEMSG_DATTAITYU_4_HRH = "（保険料払込方法変更をされた";

    private static final String KBCREDITOSIRASEMSG_DATTAITYU_4_KH = "（契約内容の変更を手続き中の";

    private static final String KBCREDITOSIRASEMSG_DATTAITYU_4_KAIYK = "（解約の手続き中の";

    private static final String KBCREDITOSIRASEMSG_DATTAITYU_4_2 = "ときは、右ページの◆をご覧ください。）";

    private static final String KBCREDITOSIRASEMSG_DATTAITYU_5_YUUYO = "つきましては、当社までご連絡のうえ、以下【保険料のご案内】に記載の猶予期間";

    private static final String KBCREDITOSIRASEMSG_DATTAITYU_6_YUUYO = "満了日までに必要な金額をお払い込みくださいますようお願いします。";

    private static final String KBCREDITOSIRASEMSG_DATTAITYU_7_YUUYO = "以下【保険料のご案内】に記載の猶予期間満了日までに保険料のお払込みがないと";

    private static final String KBCREDITOSIRASEMSG_DATTAITYU_8_YUUYO = "きは、猶予期間満了日の翌日からご契約が消滅します。";

    private static final String KBCREDITOSIRASEMSG_DATTAITYU_5_HRK = "つきましては、当社までご連絡のうえ、以下【保険料のご案内】に記載の払込期限";

    private static final String KBCREDITOSIRASEMSG_DATTAITYU_6_HRK = "日までに必要な金額をお払い込みくださいますようお願いします。";

    private static final String KBCREDITOSIRASEMSG_DATTAITYU_7_HRK = "以下【保険料のご案内】に記載の払込期限日までに保険料のお払込みがないときは";

    private static final String KBCREDITOSIRASEMSG_DATTAITYU_8_HRK = "猶予期間満了日の翌日からご契約が消滅します。";

    private static final String KBCREDITNEXTHURIKAENAIYOU_GNDGK_1 = "次回決済内容";

    private static final String KBCREDITADDMSG_MINYU_1 = "＊払込期月とは、各保険料をお払い込みいただく期限のことをいいます。";

    private static final String KBCREDITADDMSG_MINYU_2 = "　（各保険料について、お払い込みいただく月の初日から末日までの１か月となり";

    private static final String KBCREDITADDMSG_MINYU_3 = "　ます。）";

    private static final String KBCREDITADDMSG_SAIKOKU_1 = "＊払込期月とは、各保険料をお払い込みいただく月の初日から末日までの１か月の";

    private static final String KBCREDITADDMSG_SAIKOKU_2 = "　ことをいいます。";

    private static final String KBCREDITADDMSG_COMMON_1 = "＊当社職員から電話等でご連絡させていただくことがあります。";

    private static final String KBCREDITADDMSG_COMMON_2 = "＊本通知と行き違いに保険料をお払い込みいただいているときは、あしからずご了";

    private static final String KBCREDITADDMSG_COMMON_3 = "　承くださいますようお願いします。";

    private static final String KBCREDITADDMSG_COMMON_4 = "＊ご契約が消滅した場合、消滅日（※）における為替レートにより解約返戻金を";

    private static final String KBCREDITADDMSG_COMMON_5 = "　円換算してお支払いします。";

    private static final String KBCREDITADDMSG_COMMON_6 = "　※住友生命が指定する金融機関が休業日の場合は、消滅日の直後に到来する";

    private static final String KBCREDITADDMSG_COMMON_7 = "　　その金融機関の営業日とします。";

    private static final String KBCREDITADDMSG_COMMON_8 = "＊現在ご登録のクレジットカードはご利用いただけません。お払込みを再開される";

    private static final String KBCREDITADDMSG_COMMON_9 = "　ときはクレジットカードの変更手続きが必要になります。お手元に手続き書類が";

    private static final String KBCREDITADDMSG_COMMON_10 = "　ないときは、当社あてご連絡をお願いいたします。行き違いに手続き書類をご返";

    private static final String KBCREDITADDMSG_COMMON_11 = "　送いただいているときは、あしからずご了承ください。";

    private static final String KBCREDITADDMSG_COMMON_12 = "＊予定利率変動型５年ごと利差配当付指定通貨建個人年金保険は、円貨払込額";

    private static final String KBCREDITADDMSG_COMMON_13 = "　（定期一括払いの場合は、定期一括払円貨払込額）について「保険料」と表示し";

    private static final String KBCREDITADDMSG_COMMON_14 = "　ております。";

    private static final String KBCREDITADDMSG1_GNDGK1 = "＊クレジットカードのご利用日は毎月１５日です。ご指定口座からの振替日はクレ";

    private static final String KBCREDITADDMSG1_GNDGK2 = "　ジットカード会社によって異なり、ご利用日の翌月や翌々月となることがござい";

    private static final String KBCREDITADDMSG1_GNDGK3 = "　ます。";

    private static final String KBCREDITADDMSG1_GNDGK_YUUYO_1 = "＊猶予期間満了日までに別途保険料のお払込みをご希望のときは、当社までご連絡";

    private static final String KBCREDITADDMSG1_GNDGK_YUUYO_2 = "　をお願いいたします。";

    private static final String KBCREDITADDMSG1_GNDGK_HRK_1 = "＊払込期限日までに別途保険料のお払込みをご希望のときは、当社までご連絡をお";

    private static final String KBCREDITADDMSG1_GNDGK_HRK_2 = "　願いいたします。";

    private static final String KBCREDITADDMSG2_YKKIGENKIRE_1 = "◆ご契約の効力に関する重要なお知らせにつき、つぎのいずれかでお手続き中のお";

    private static final String KBCREDITADDMSG2_YKKIGENKIRE_2 = "　客さまへも本通知を送付しております。あしからずご了承ください。";

    private static final String KBCREDITADDMSG2_YKKIGENKIRE_3 = "　　・保険料のお払込方法変更手続き中のお客さま";

    private static final String KBCREDITADDMSG2_YKKIGENKIRE_4 = "　　・当社からクレジットカードの変更手続きをご案内しているお客さま";

    private static final String KBCREDITADDMSG2_YKKIGENKIRE_5 = "　　　（ご登録のクレジットカードが「有効期限切れ」でご利用できず、当社から";

    private static final String KBCREDITADDMSG2_YKKIGENKIRE_6 = "　　　「保険料お払込方法変更のお願い」を送付しているお客さま）";

    private static final String KBCREDITADDMSG2_YKKIGENKIRE_7 = "　　クレジットカードの変更書類をご返送いただいていないときは、左ページに記";

    private static final String KBCREDITADDMSG2_YKKIGENKIRE_8_YUUYO = "　　載の猶予期間満了日までに当社必着でご返送ください。";

    private static final String KBCREDITADDMSG2_YKKIGENKIRE_8_HRK = "　　載の払込期限日までに当社必着でご返送ください。";

    private static final String KBCREDITADDMSG2_YKKIGENKIRE_9 = "　　手続き書類がお手元にないときは、当社あてご連絡をお願いいたします。行き";

    private static final String KBCREDITADDMSG2_YKKIGENKIRE_10 = "　　違いに手続き書類をご返送いただいているときは、あしからずご了承くださ";

    private static final String KBCREDITADDMSG2_YKKIGENKIRE_11 = "　　い。";

    private static final String KBCREDITADDMSG3_DATTAITYU_1_HRH = "◆保険料のお払込方法変更手続き中のお客さまへ";

    private static final String KBCREDITADDMSG3_DATTAITYU_2_HRH = "　ご契約の効力に関する重要なお知らせにつき、保険料の払込方法変更手続きによ";

    private static final String KBCREDITADDMSG3_DATTAITYU_3_HRH = "　り保険料のお払込みを停止したご契約につきましても、本通知を送付しておりま";

    private static final String KBCREDITADDMSG3_DATTAITYU_4_HRH = "　す。あしからずご了承ください。";

    private static final String KBCREDITADDMSG4_DATTAITYU_1_KH = "◆契約内容の変更を手続き中のお客さまへ";

    private static final String KBCREDITADDMSG4_DATTAITYU_2_KH = "　ご契約の効力に関する重要なお知らせにつき、契約内容の変更の手続きを承って";

    private static final String KBCREDITADDMSG4_DATTAITYU_3_KH = "　いるご契約につきましても、本通知を送付しております。あしからずご了承くだ";

    private static final String KBCREDITADDMSG4_DATTAITYU_4_KH = "　さい。";

    private static final String KBCREDITADDMSG5_DATTAITYU_1_KAIYK = "◆解約の手続き中のお客さまへ";

    private static final String KBCREDITADDMSG5_DATTAITYU_2_KAIYK = "　ご契約の効力に関する重要なお知らせにつき、解約の手続きを承っているご契約";

    private static final String KBCREDITADDMSG5_DATTAITYU_3_KAIYK = "　につきましても、本通知を送付しております。あしからずご了承ください。";

    private static final String KBCREDITADDMSG6_DATTAITYU_1_SONOTA = "＊ご契約の効力に関する重要なお知らせにつき、解約等の手続きを承っているご契";

    private static final String KBCREDITADDMSG6_DATTAITYU_2_SONOTA = "　約につきましても、本通知を送付しております。あしからずご了承ください。";

    private static final String KBCREDITADDMSG6_DATTAITYU_3_SONOTA = "＊現在ご登録のクレジットカードはご利用いただけません。お払込みを再開される";

    private static final String KBCREDITADDMSG6_DATTAITYU_4_SONOTA = "　ときはクレジットカードの変更手続きが必要になります。お手元に手続き書類が";

    private static final String KBCREDITADDMSG6_DATTAITYU_5_SONOTA = "　ないときは、当社あてご連絡をお願いいたします。";

    private static final String KBCREDITADDMSG7_DATTAITYU_1_NGDATTAI = "＊クレジットカードの変更手続き書類がお手元にないときは、当社あてご連絡を";

    private static final String KBCREDITADDMSG7_DATTAITYU_2_NGDATTAI = "　お願いします。";

    public EditMinyuuTuuti() {
        super();
    }

    public IT_KouzahuriMinyuTuuti editTBL(KhozenCommonParam pKhozenCommonParam,
        IT_KykKihon pKykKihon,
        EditMinyuuTuutiParam pEditMinyuuTuutiParam,
        BizDate pSyoriymd,
        C_HassouKbn pHassouKbn,
        String pTuutisyuruicd) {

        Boolean tjyMinyuRiyuuFlag = false;
        String tuutiNm = "";
        C_Skszumiflg saikokuTuutiZumiflg = C_Skszumiflg.MISAKUSEI;
        String  minyuttMsg1 = "";
        String  minyuttMsg2 = "";
        String  minyuttMsg3 = "";
        String  minyuttMsg4 = "";
        String  minyuttMsg5 = "";
        String  minyuttMsg6 = "";
        String  minyuttMsg7 = "";
        String  minyuttMsg8 = "";
        String  minyuttMsg9 = "";
        String  minyuttMsg10 = "";
        String  minyuttMsg11 = "";
        String  minyuttMsg12 = "";
        String hrkHouhou = "";
        String nextHurikaeNaiyou1 = "";
        String nextHurikaeNaiyou2 = "";
        String nextHurikaeNaiyou3 = "";
        String hrkmirMsg1 = "";
        String hrkmirMsg2 = "";
        String hrkmirMsg3 = "";
        String zenHurikaeNaiyou1 = "";
        String zenHurikaeNaiyou2 = "";
        String zenHurikaeNaiyou3 = "";
        String zenHurikaeNaiyou4 = "";
        String hurikaeKz1 = "";
        String hurikaeKz2 = "";
        String hurikaeKz3 = "";
        String hurikaeKz4 = "";
        String hurikaeKz5 = "";
        String hurikaeKz6 = "";
        String minyuttAddMsg1 = "";
        String minyuttAddMsg2 = "";
        String minyuttAddMsg3 = "";
        String minyuttAddMsg4 = "";
        String minyuttAddMsg5 = "";
        String minyuttAddMsg6 = "";
        String minyuttAddMsg7 = "";
        String minyuttAddMsg8 = "";
        String minyuttAddMsg9 = "";
        String minyuttAddMsg10 = "";
        String minyuttAddMsg11 = "";
        String minyuttAddMsg12 = "";
        String minyuttAddMsg13 = "";
        String minyuttAddMsg14 = "";
        String minyuttAddMsg15 = "";
        String minyuttAddMsg16 = "";
        String minyuttAddMsg17 = "";
        String minyuttAddMsg18 = "";
        String minyuttAddMsg19 = "";
        String minyuttAddMsg20 = "";
        String minyuttAddMsg21 = "";

        IT_KykSya kykSya = pKykKihon.getKykSya();

        IT_HhknSya hhknSya = pKykKihon.getHhknSya();

        BzGetSosikiMadogutiInfo bzGetSosikiMadogutiInfo = SWAKInjector.getInstance(BzGetSosikiMadogutiInfo.class);

        BzGetSosikiMadogutiInfoKekkaBean bzGetSosikiMadogutiInfoKekkaBean =
            bzGetSosikiMadogutiInfo.exec(YuyuBizConfig.getInstance().getCallcentersosikicd());

        BizDateYM hurikaeYmYokugetu = pEditMinyuuTuutiParam.getHurikaeYm().addMonths(1);

        if (C_UmuKbn.NONE.eq(pEditMinyuuTuutiParam.getDattaiUktkUmu())) {

            if (C_HurihunoKbn.NOKOUHURIIRAI.eq(pEditMinyuuTuutiParam.getHurihunoKbn()) ||
                C_HurihunoKbn.ITKTUGOU.eq(pEditMinyuuTuutiParam.getHurihunoKbn()) ||
                C_HurihunoKbn.SIKINHUSOKU.eq(pEditMinyuuTuutiParam.getHurihunoKbn()) ||
                C_HurihunoKbn.YKNSYATUGOU.eq(pEditMinyuuTuutiParam.getHurihunoKbn())) {

                tjyMinyuRiyuuFlag = true;
            }
            else {

                tjyMinyuRiyuuFlag = false;
            }
        }

        BizDate jkiHurikaeYmdZnegyb = pEditMinyuuTuutiParam.getJkiHurikaeYmd().addBusinessDays(-1);

        String dispJkiHurikaeYmdZnegyb = FixedDateFormatter.formatYMDZenkakuSeirekiKanji(jkiHurikaeYmdZnegyb);

        BizDateYM nextRyosyuYm = null;
        if (pEditMinyuuTuutiParam.getJkiHurikaeYmd().getDay() < 27) {
            nextRyosyuYm = pEditMinyuuTuutiParam.getJkiHurikaeYmd().getBizDateYM().getPreviousMonth();
        }
        else {
            nextRyosyuYm = pEditMinyuuTuutiParam.getJkiHurikaeYmd().getBizDateYM();
        }

        String dispYykknMnryYmd = FixedDateFormatter.formatYMDZenkakuSeirekiKanji(pEditMinyuuTuutiParam.getYykknMnryYmd());

        String dispJkiPJytYm = FixedDateFormatter.formatYMZenkakuSeirekiKanji(pEditMinyuuTuutiParam.getJkiPJytYm().getFirstDay());

        String dispSaikokuTaisyouM = FixedDateFormatter.formatMZenkakuKanji(pEditMinyuuTuutiParam.getJkiPJytYm().getFirstDay());

        String dispJkiHurikaeM = FixedDateFormatter.formatMZenkakuKanji(nextRyosyuYm.getFirstDay());

        String dispJkiAnnaiJyuutouTukisuu = Strings.padStart(
            ConvertUtil.toZenNumeric(String.valueOf(pEditMinyuuTuutiParam.getJkiAnnaiJyuutouTukisuu())), 2, '　');

        String dispJkiAnnaiKg = Strings.padStart(
            ConvertUtil.toZenAll(BizUtil.comma(pEditMinyuuTuutiParam.getJkiAnnaiKg().toAdsoluteString()), 0, 0), 11, '　');

        String dispJkiHurikaeYmd = FixedDateFormatter.formatYMDZenkakuSeirekiKanji(pEditMinyuuTuutiParam.getJkiHurikaeYmd());

        String dispZenHurikaeM = FixedDateFormatter.formatMZenkakuKanji(pEditMinyuuTuutiParam.getHurikaeYm().getFirstDay());

        String dispZenAnnaiJyutouYm = FixedDateFormatter.formatYMZenkakuSeirekiKanji(pEditMinyuuTuutiParam.getZenAnnaiJyutouYm().getFirstDay());

        String dispZenAnnaiJyuutouTukisuu = Strings.padStart(
            ConvertUtil.toZenNumeric(String.valueOf(pEditMinyuuTuutiParam.getZenAnnaiJyuutouTukisuu())), 2, '　');

        String dispZenAnnaiKg = Strings.padStart(
            ConvertUtil.toZenAll(BizUtil.comma(pEditMinyuuTuutiParam.getZenAnnaiKg().toAdsoluteString()), 0, 0), 11, '　');

        String dispZenHurikaeYmd = FixedDateFormatter.formatYMDZenkakuSeirekiKanji(pEditMinyuuTuutiParam.getZenHurikaeYmd());

        BizDateYM yykknMnryYm;
        if (pEditMinyuuTuutiParam.getYykknMnryYmd().getDay() < 27) {

            yykknMnryYm = pEditMinyuuTuutiParam.getYykknMnryYmd().getBizDateYM().getPreviousMonth();
        }
        else {

            yykknMnryYm = pEditMinyuuTuutiParam.getYykknMnryYmd().getBizDateYM();
        }

        if (BizDateUtil.compareYm(yykknMnryYm , hurikaeYmYokugetu) == BizDateUtil.COMPARE_LESSER) {

            yykknMnryYm = hurikaeYmYokugetu;
        }

        C_HurihunoKbn zenHurihunoKbn;
        if (C_HurihunoKbn.NOKOUHURIIRAI.eq(pEditMinyuuTuutiParam.getHurihunoKbn()) ||
            C_HurihunoKbn.ITKTUGOU.eq(pEditMinyuuTuutiParam.getHurihunoKbn()) ||
            C_HurihunoKbn.YKNSYATUGOU.eq(pEditMinyuuTuutiParam.getHurihunoKbn())) {

            zenHurihunoKbn = pEditMinyuuTuutiParam.getZenHurihunoKbn();
        }
        else {

            zenHurihunoKbn = C_HurihunoKbn.BLNK;
        }

        if (BizDateUtil.compareYm(hurikaeYmYokugetu,
            yykknMnryYm) == BizDateUtil.COMPARE_EQUAL) {
            if ((C_UmuKbn.NONE.eq(pEditMinyuuTuutiParam.getDattaiUktkUmu()) &&
                !pEditMinyuuTuutiParam.getHurihunoKbn().eq(zenHurihunoKbn) &&
                tjyMinyuRiyuuFlag) || C_UmuKbn.ARI.eq(pEditMinyuuTuutiParam.getKouzaHenkouUmuKbn())) {

                tuutiNm = KBTUUTINM4;
                saikokuTuutiZumiflg = C_Skszumiflg.SAKUSEIZUMI;

            }
            else {

                tuutiNm = KBTUUTINM2;
                saikokuTuutiZumiflg = C_Skszumiflg.SAKUSEIZUMI;
            }
        }
        else {

            if ((C_UmuKbn.NONE.eq(pEditMinyuuTuutiParam.getDattaiUktkUmu()) &&
                !pEditMinyuuTuutiParam.getHurihunoKbn().eq(zenHurihunoKbn) &&
                tjyMinyuRiyuuFlag) || C_UmuKbn.ARI.eq(pEditMinyuuTuutiParam.getKouzaHenkouUmuKbn())) {

                tuutiNm = KBTUUTINM3;
                saikokuTuutiZumiflg = C_Skszumiflg.MISAKUSEI;
            }
            else {

                tuutiNm = KBTUUTINM1;
                saikokuTuutiZumiflg = C_Skszumiflg.MISAKUSEI;
            }
        }

        if (C_UmuKbn.NONE.eq(pEditMinyuuTuutiParam.getDattaiUktkUmu()) ||
            C_UmuKbn.ARI.eq(pEditMinyuuTuutiParam.getKouzaHenkouUmuKbn())) {

            if ((!pEditMinyuuTuutiParam.getHurihunoKbn().eq(zenHurihunoKbn) &&
                tjyMinyuRiyuuFlag) || C_UmuKbn.ARI.eq(pEditMinyuuTuutiParam.getKouzaHenkouUmuKbn())) {

                minyuttMsg1 = KBOSIRASEMSGCD5_1;
                minyuttMsg2 = KBOSIRASEMSGCD5_2_1 + dispJkiPJytYm + KBOSIRASEMSGCD5_2_2;
                minyuttMsg3 = KBOSIRASEMSGCD5_3;
                minyuttMsg4 = KBOSIRASEMSGCD5_4_1 + dispJkiHurikaeM + KBOSIRASEMSGCD5_4_2;
                minyuttMsg5 = KBOSIRASEMSGCD5_5_1 + dispJkiHurikaeYmdZnegyb + KBOSIRASEMSGCD5_5_2;
                minyuttMsg6 = KBOSIRASEMSGCD5_6;
                minyuttMsg7 = KBOSIRASEMSGCD5_7;
                minyuttMsg8 = KBOSIRASEMSGCD5_8;
                minyuttMsg9 = KBOSIRASEMSGCD5_9;
                minyuttMsg10 = KBOSIRASEMSGCD5_10;
                minyuttMsg11 = KBOSIRASEMSGCD5_11;
                minyuttMsg12 = KBOSIRASEMSGCD5_12;
            }
            else {

                minyuttMsg1 = KBOSIRASEMSGCD3_1;
                minyuttMsg2 = KBOSIRASEMSGCD3_2;
                minyuttMsg3 = KBOSIRASEMSGCD3_3_1 + dispJkiPJytYm + KBOSIRASEMSGCD3_3_2;
                minyuttMsg4 = KBOSIRASEMSGCD3_4;
                minyuttMsg5 = KBOSIRASEMSGCD3_5;
                minyuttMsg6 = KBOSIRASEMSGCD3_6;
                minyuttMsg7 = KBOSIRASEMSGCD3_7;
                minyuttMsg8 = KBOSIRASEMSGCD3_8;
                minyuttMsg9 = KBOSIRASEMSGCD3_9;
                minyuttMsg10 = KBOSIRASEMSGCD3_10;
                minyuttMsg11 = KBOSIRASEMSGCD3_11;
                minyuttMsg12 = KBOSIRASEMSGCD3_12;
            }
        }
        else {

            if (C_DattairiyuuKbn.HRHENKIBOU.eq(pEditMinyuuTuutiParam.getDattaiRiyuuKbn())) {

                minyuttMsg1 = KBOSIRASEMSGCD1_1;
                minyuttMsg2 = KBOSIRASEMSGCD1_2;
                minyuttMsg3 = KBOSIRASEMSGCD1_3_1 + dispJkiPJytYm + KBOSIRASEMSGCD1_3_2;
                minyuttMsg4 = KBOSIRASEMSGCD1_4;
                minyuttMsg5 = KBOSIRASEMSGCD1_5;
                minyuttMsg6 = KBOSIRASEMSGCD1_6;
                minyuttMsg7 = KBOSIRASEMSGCD1_7;
                minyuttMsg8 = KBOSIRASEMSGCD1_8;
                minyuttMsg9 = KBOSIRASEMSGCD1_9;
                minyuttMsg10 = KBOSIRASEMSGCD1_10;
                minyuttMsg11 = KBOSIRASEMSGCD1_11;
                minyuttMsg12 = KBOSIRASEMSGCD1_12;
            }
            else if(C_DattairiyuuKbn.KAIYAKUKIBOU.eq(pEditMinyuuTuutiParam.getDattaiRiyuuKbn())) {

                minyuttMsg1 = KBOSIRASEMSGCD2_1;
                minyuttMsg2 = KBOSIRASEMSGCD2_2;
                minyuttMsg3 = KBOSIRASEMSGCD2_3_1 + dispJkiPJytYm + KBOSIRASEMSGCD2_3_2;
                minyuttMsg4 = KBOSIRASEMSGCD2_4;
                minyuttMsg5 = KBOSIRASEMSGCD2_5;
                minyuttMsg6 = KBOSIRASEMSGCD2_6;
                minyuttMsg7 = KBOSIRASEMSGCD2_7;
                minyuttMsg8 = KBOSIRASEMSGCD2_8;
                minyuttMsg9 = KBOSIRASEMSGCD2_9;
                minyuttMsg10 = KBOSIRASEMSGCD2_10;
                minyuttMsg11 = KBOSIRASEMSGCD2_11;
                minyuttMsg12 = KBOSIRASEMSGCD2_12;
            }
            else if (C_DattairiyuuKbn.KEIYAKUHENKOUARI.eq(pEditMinyuuTuutiParam.getDattaiRiyuuKbn())) {

                minyuttMsg1 = KBOSIRASEMSGCD4_1;
                minyuttMsg2 = KBOSIRASEMSGCD4_2;
                minyuttMsg3 = KBOSIRASEMSGCD4_3_1 + dispJkiPJytYm + KBOSIRASEMSGCD4_3_2;
                minyuttMsg4 = KBOSIRASEMSGCD4_4;
                minyuttMsg5 = KBOSIRASEMSGCD4_5;
                minyuttMsg6 = KBOSIRASEMSGCD4_6;
                minyuttMsg7 = KBOSIRASEMSGCD4_7;
                minyuttMsg8 = KBOSIRASEMSGCD4_8;
                minyuttMsg9 = KBOSIRASEMSGCD4_9;
                minyuttMsg10 = KBOSIRASEMSGCD4_10;
                minyuttMsg11 = KBOSIRASEMSGCD4_11;
                minyuttMsg12 = KBOSIRASEMSGCD4_12;
            }
            else {

                minyuttMsg1 = KBOSIRASEMSGCD3_1;
                minyuttMsg2 = KBOSIRASEMSGCD3_2;
                minyuttMsg3 = KBOSIRASEMSGCD3_3_1 + dispJkiPJytYm + KBOSIRASEMSGCD3_3_2;
                minyuttMsg4 = KBOSIRASEMSGCD3_4;
                minyuttMsg5 = KBOSIRASEMSGCD3_5;
                minyuttMsg6 = KBOSIRASEMSGCD3_6;
                minyuttMsg7 = KBOSIRASEMSGCD3_7;
                minyuttMsg8 = KBOSIRASEMSGCD3_8;
                minyuttMsg9 = KBOSIRASEMSGCD3_9;
                minyuttMsg10 = KBOSIRASEMSGCD3_10;
                minyuttMsg11 = KBOSIRASEMSGCD3_11;
                minyuttMsg12 = KBOSIRASEMSGCD3_12;
            }
        }

        if (C_Hrkkaisuu.TUKI.eq(pKykKihon.getHrkkaisuu())) {

            if (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(pKykKihon.getTikiktbrisyuruikbn()) ||
                C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(pKykKihon.getTikiktbrisyuruikbn())) {

                hrkHouhou = pKykKihon.getTikiktbrisyuruikbn().getContent() + "払";
            }
            else {

                hrkHouhou = pKykKihon.getHrkkaisuu().getContent();
            }
        }

        if ((C_UmuKbn.NONE.eq(pEditMinyuuTuutiParam.getDattaiUktkUmu()) &&
            !pEditMinyuuTuutiParam.getHurihunoKbn().eq(zenHurihunoKbn) &&
            tjyMinyuRiyuuFlag) || C_UmuKbn.ARI.eq(pEditMinyuuTuutiParam.getKouzaHenkouUmuKbn())) {

            nextHurikaeNaiyou1 = KBNEXTHURIKAEMAIYOU2_1;

            nextHurikaeNaiyou2 = dispJkiHurikaeM + KBNEXTHURIKAEMAIYOU2_2_1 + dispJkiHurikaeYmd + KBNEXTHURIKAEMAIYOU2_2_2;

            nextHurikaeNaiyou3 = KBNEXTHURIKAEMAIYOU2_3_1 + dispJkiAnnaiKg + KBNEXTHURIKAEMAIYOU2_3_2  +
                dispJkiPJytYm + KBNEXTHURIKAEMAIYOU2_3_3  + dispJkiAnnaiJyuutouTukisuu + KBNEXTHURIKAEMAIYOU2_3_4;
        }
        else {

            nextHurikaeNaiyou1 = KBNEXTHURIKAEMAIYOU1_1;

            nextHurikaeNaiyou2 = KBNEXTHURIKAEMAIYOU1_2_1 + dispZenAnnaiKg + KBNEXTHURIKAEMAIYOU1_2_2 +
                dispZenAnnaiJyutouYm + KBNEXTHURIKAEMAIYOU1_2_3  + dispZenAnnaiJyuutouTukisuu + KBNEXTHURIKAEMAIYOU1_2_4;

            nextHurikaeNaiyou3 = KBNEXTHURIKAEMAIYOU1_3;
        }

        if (BizDateUtil.compareYm(hurikaeYmYokugetu, yykknMnryYm) == BizDateUtil.COMPARE_EQUAL) {

            if ((C_UmuKbn.NONE.eq(pEditMinyuuTuutiParam.getDattaiUktkUmu()) &&
                !pEditMinyuuTuutiParam.getHurihunoKbn().eq(zenHurihunoKbn) &&
                tjyMinyuRiyuuFlag) || C_UmuKbn.ARI.eq(pEditMinyuuTuutiParam.getKouzaHenkouUmuKbn())) {

                hrkmirMsg1 = KBHRKMIRMSG1_1 + dispJkiHurikaeYmd + KBHRKMIRMSG1_2;

                hrkmirMsg2 = KBHRKMIRMSG2_1 + dispYykknMnryYmd + KBHRKMIRMSG2_2;

                hrkmirMsg3 = KBHRKMIRMSG3;
            }
        }

        if (C_UmuKbn.NONE.eq(pEditMinyuuTuutiParam.getDattaiUktkUmu()) &&
            C_UmuKbn.NONE.eq(pEditMinyuuTuutiParam.getKouzaHenkouUmuKbn())) {

            if (C_HurihunoKbn.SIKINHUSOKU.eq(pEditMinyuuTuutiParam.getHurihunoKbn())) {

                zenHurikaeNaiyou1 = KBZENHURIKAENAIYOU3_1;

                zenHurikaeNaiyou2 = dispZenHurikaeM + KBZENHURIKAENAIYOU3_2_1 + dispZenHurikaeYmd + KBZENHURIKAENAIYOU3_2_2;

                zenHurikaeNaiyou3 = KBZENHURIKAENAIYOU3_3_1 + dispZenAnnaiJyutouYm +
                    KBZENHURIKAENAIYOU3_3_2 + dispZenAnnaiJyuutouTukisuu + KBZENHURIKAENAIYOU3_3_3 +
                    dispZenAnnaiKg + KBZENHURIKAENAIYOU3_3_4;

                zenHurikaeNaiyou4 = KBZENHURIKAENAIYOU3_4;
            }
            else if (C_HurihunoKbn.YKNSYATUGOU.eq(pEditMinyuuTuutiParam.getHurihunoKbn())) {

                zenHurikaeNaiyou1 = KBZENHURIKAENAIYOU4_1;

                zenHurikaeNaiyou2 = dispZenHurikaeM + KBZENHURIKAENAIYOU4_2_1 + dispZenHurikaeYmd + KBZENHURIKAENAIYOU4_2_2;

                zenHurikaeNaiyou3 = KBZENHURIKAENAIYOU4_3_1 + dispZenAnnaiJyutouYm +
                    KBZENHURIKAENAIYOU4_3_2 + dispZenAnnaiJyuutouTukisuu + KBZENHURIKAENAIYOU4_3_3 +
                    dispZenAnnaiKg + KBZENHURIKAENAIYOU4_3_4;

                zenHurikaeNaiyou4 = KBZENHURIKAENAIYOU4_4;
            }
            else {

                zenHurikaeNaiyou1 = KBZENHURIKAENAIYOU2_1;

                zenHurikaeNaiyou2 = dispZenHurikaeM + KBZENHURIKAENAIYOU2_2_1 + dispZenHurikaeYmd + KBZENHURIKAENAIYOU2_2_2;

                zenHurikaeNaiyou3 = KBZENHURIKAENAIYOU2_3_1 + dispZenAnnaiJyutouYm +
                    KBZENHURIKAENAIYOU2_3_2 + dispZenAnnaiJyuutouTukisuu + KBZENHURIKAENAIYOU2_3_3 +
                    dispZenAnnaiKg + KBZENHURIKAENAIYOU2_3_4;

                zenHurikaeNaiyou4 = KBZENHURIKAENAIYOU2_4;
            }
        }
        else if (C_UmuKbn.ARI.eq(pEditMinyuuTuutiParam.getKouzaHenkouUmuKbn())) {

            zenHurikaeNaiyou1 = KBZENHURIKAENAIYOU2_1;

            zenHurikaeNaiyou2 = dispZenHurikaeM + KBZENHURIKAENAIYOU2_2_1 + dispZenHurikaeYmd + KBZENHURIKAENAIYOU2_2_2;

            zenHurikaeNaiyou3 = KBZENHURIKAENAIYOU2_3_1 + dispZenAnnaiJyutouYm +
                KBZENHURIKAENAIYOU2_3_2 + dispZenAnnaiJyuutouTukisuu + KBZENHURIKAENAIYOU2_3_3 +
                dispZenAnnaiKg + KBZENHURIKAENAIYOU2_3_4;

            zenHurikaeNaiyou4 = KBZENHURIKAENAIYOU2_4;
        }

        IT_Kouza kouza = pKykKihon.getKouza();

        BzGetBankData bzGetBankData = SWAKInjector.getInstance(BzGetBankData.class);

        BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(kouza.getBankcd(), kouza.getSitencd());

        String bankNmKj = bzGetBankDataBean.getBankNmKj();

        String sitenNmKj = bzGetBankDataBean.getReportSitenNm();

        String updKouzaNo = ConvertUtil.toZenAll(KhozenEdit.editKouzaNo(kouza.getBankcd(), kouza.getKouzano()), 0, 0);

        if (IGkCommonKoumoku.BANKCD_YTGINKOU.equals(kouza.getBankcd())) {

            hurikaeKz1 = KBHURIKAEKZ1_1;
            hurikaeKz2 = bankNmKj;
            hurikaeKz3 = sitenNmKj;
            hurikaeKz4 = KBHURIKAEKZ1_4 + updKouzaNo;
            hurikaeKz5 = KBHURIKAEKZ1_5_1 + kouza.getKzmeiginmkn() + KBHURIKAEKZ1_5_2;
            hurikaeKz6 = KBHURIKAEKZ1_6;
        }
        else {

            hurikaeKz1 = KBHURIKAEKZ2_1;
            hurikaeKz2 = bankNmKj;
            hurikaeKz3 = sitenNmKj;
            hurikaeKz4 = kouza.getYokinkbn().getContent(C_YokinKbn.PATTERN_TYOUHYOU) +
                KBHURIKAEKZ2_4_2 + updKouzaNo;
            hurikaeKz5 = KBHURIKAEKZ2_5_1 + kouza.getKzmeiginmkn() + KBHURIKAEKZ2_5_2;
            hurikaeKz6 = KBHURIKAEKZ2_6;
        }

        if (BizDateUtil.compareYm(hurikaeYmYokugetu,
            yykknMnryYm) == BizDateUtil.COMPARE_LESSER) {

            if (C_UmuKbn.NONE.eq(pEditMinyuuTuutiParam.getDattaiUktkUmu()) ||
                C_UmuKbn.ARI.eq(pEditMinyuuTuutiParam.getKouzaHenkouUmuKbn())) {

                if ((!pEditMinyuuTuutiParam.getHurihunoKbn().eq(zenHurihunoKbn) &&
                    tjyMinyuRiyuuFlag) || C_UmuKbn.ARI.eq(pEditMinyuuTuutiParam.getKouzaHenkouUmuKbn())) {

                    minyuttAddMsg1 = KBMINYUTTADDMSG1_1;
                    minyuttAddMsg2 = KBMINYUTTADDMSG1_2;
                    minyuttAddMsg3 = KBMINYUTTADDMSG1_3;
                    minyuttAddMsg4 = KBMINYUTTADDMSG1_4;
                    minyuttAddMsg5 = KBMINYUTTADDMSG1_5;
                    minyuttAddMsg6 = KBMINYUTTADDMSG1_6;
                    minyuttAddMsg7 = KBMINYUTTADDMSG1_7;
                    minyuttAddMsg8 = KBMINYUTTADDMSG1_8;
                    minyuttAddMsg9 = KBMINYUTTADDMSG1_9;
                    minyuttAddMsg10 = KBMINYUTTADDMSG1_10;
                    minyuttAddMsg11 = KBMINYUTTADDMSG1_11;
                    minyuttAddMsg12 = KBMINYUTTADDMSG1_12;
                    minyuttAddMsg13 = KBMINYUTTADDMSG1_13;
                    minyuttAddMsg14 = KBMINYUTTADDMSG1_14;
                    minyuttAddMsg15 = KBMINYUTTADDMSG1_15;
                    minyuttAddMsg16 = KBADDMSG_TIKIKTBRI_1;
                    minyuttAddMsg17 = KBADDMSG_TIKIKTBRI_2;
                    minyuttAddMsg18 = KBMINYUTTADDMSG1_18;
                    minyuttAddMsg19 = KBMINYUTTADDMSG1_19;
                    minyuttAddMsg20 = KBMINYUTTADDMSG1_20;
                    minyuttAddMsg21 = KBMINYUTTADDMSG1_21;
                }
                else {

                    minyuttAddMsg1 = KBMINYUTTADDMSG11_1;
                    minyuttAddMsg2 = KBMINYUTTADDMSG11_2;
                    minyuttAddMsg3 = KBMINYUTTADDMSG11_3;
                    minyuttAddMsg4 = KBMINYUTTADDMSG11_4;
                    minyuttAddMsg5 = KBMINYUTTADDMSG11_5;
                    minyuttAddMsg6 = KBMINYUTTADDMSG11_6;
                    minyuttAddMsg7 = KBMINYUTTADDMSG11_7;
                    minyuttAddMsg8 = KBMINYUTTADDMSG11_8;
                    minyuttAddMsg9 = KBMINYUTTADDMSG11_9;
                    minyuttAddMsg10 = KBMINYUTTADDMSG11_10;
                    minyuttAddMsg11 = KBMINYUTTADDMSG11_11;
                    minyuttAddMsg12 = KBMINYUTTADDMSG11_12;
                    minyuttAddMsg13 = KBMINYUTTADDMSG11_13;
                    minyuttAddMsg14 = KBMINYUTTADDMSG11_14;
                    minyuttAddMsg15 = KBMINYUTTADDMSG11_15;
                    minyuttAddMsg16 = KBMINYUTTADDMSG11_16;
                    minyuttAddMsg17 = KBMINYUTTADDMSG11_17;
                    minyuttAddMsg18 = KBMINYUTTADDMSG11_18;
                    minyuttAddMsg19 = KBADDMSG_TIKIKTBRI_1;
                    minyuttAddMsg20 = KBADDMSG_TIKIKTBRI_2;
                    minyuttAddMsg21 = KBMINYUTTADDMSG11_21;
                }
            }
            else {

                if (C_DattairiyuuKbn.HRHENKIBOU.eq(pEditMinyuuTuutiParam.getDattaiRiyuuKbn())) {

                    minyuttAddMsg1 = KBMINYUTTADDMSG3_1;
                    minyuttAddMsg2 = KBMINYUTTADDMSG3_2;
                    minyuttAddMsg3 = KBMINYUTTADDMSG3_3;
                    minyuttAddMsg4 = KBMINYUTTADDMSG3_4;
                    minyuttAddMsg5 = KBMINYUTTADDMSG3_5;
                    minyuttAddMsg6 = KBMINYUTTADDMSG3_6;
                    minyuttAddMsg7 = KBMINYUTTADDMSG3_7;
                    minyuttAddMsg8 = KBMINYUTTADDMSG3_8;
                    minyuttAddMsg9 = KBMINYUTTADDMSG3_9;
                    minyuttAddMsg10 = KBMINYUTTADDMSG3_10;
                    minyuttAddMsg11 = KBMINYUTTADDMSG3_11;
                    minyuttAddMsg12 = KBMINYUTTADDMSG3_12;
                    minyuttAddMsg13 = KBMINYUTTADDMSG3_13;
                    minyuttAddMsg14 = KBMINYUTTADDMSG3_14;
                    minyuttAddMsg15 = KBADDMSG_TIKIKTBRI_1;
                    minyuttAddMsg16 = KBADDMSG_TIKIKTBRI_2;
                    minyuttAddMsg17 = KBMINYUTTADDMSG3_17;
                    minyuttAddMsg18 = KBMINYUTTADDMSG3_18;
                    minyuttAddMsg19 = KBMINYUTTADDMSG3_19;
                    minyuttAddMsg20 = KBMINYUTTADDMSG3_20;
                    minyuttAddMsg21 = KBMINYUTTADDMSG3_21;
                }
                else if(C_DattairiyuuKbn.KAIYAKUKIBOU.eq(pEditMinyuuTuutiParam.getDattaiRiyuuKbn())) {

                    minyuttAddMsg1 = KBMINYUTTADDMSG5_1;
                    minyuttAddMsg2 = KBMINYUTTADDMSG5_2;
                    minyuttAddMsg3 = KBMINYUTTADDMSG5_3;
                    minyuttAddMsg4 = KBMINYUTTADDMSG5_4;
                    minyuttAddMsg5 = KBMINYUTTADDMSG5_5;
                    minyuttAddMsg6 = KBMINYUTTADDMSG5_6;
                    minyuttAddMsg7 = KBMINYUTTADDMSG5_7;
                    minyuttAddMsg8 = KBMINYUTTADDMSG5_8;
                    minyuttAddMsg9 = KBMINYUTTADDMSG5_9;
                    minyuttAddMsg10 = KBMINYUTTADDMSG5_10;
                    minyuttAddMsg11 = KBMINYUTTADDMSG5_11;
                    minyuttAddMsg12 = KBMINYUTTADDMSG5_12;
                    minyuttAddMsg13 = KBMINYUTTADDMSG5_13;
                    minyuttAddMsg14 = KBMINYUTTADDMSG5_14;
                    minyuttAddMsg15 = KBADDMSG_TIKIKTBRI_1;
                    minyuttAddMsg16 = KBADDMSG_TIKIKTBRI_2;
                    minyuttAddMsg17 = KBMINYUTTADDMSG5_17;
                    minyuttAddMsg18 = KBMINYUTTADDMSG5_18;
                    minyuttAddMsg19 = KBMINYUTTADDMSG5_19;
                    minyuttAddMsg20 = KBMINYUTTADDMSG5_20;
                    minyuttAddMsg21 = KBMINYUTTADDMSG5_21;
                }
                else if (C_DattairiyuuKbn.KEIYAKUHENKOUARI.eq(pEditMinyuuTuutiParam.getDattaiRiyuuKbn())) {

                    minyuttAddMsg1 = KBMINYUTTADDMSG7_1;
                    minyuttAddMsg2 = KBMINYUTTADDMSG7_2;
                    minyuttAddMsg3 = KBMINYUTTADDMSG7_3;
                    minyuttAddMsg4 = KBMINYUTTADDMSG7_4;
                    minyuttAddMsg5 = KBMINYUTTADDMSG7_5;
                    minyuttAddMsg6 = KBMINYUTTADDMSG7_6;
                    minyuttAddMsg7 = KBMINYUTTADDMSG7_7;
                    minyuttAddMsg8 = KBMINYUTTADDMSG7_8;
                    minyuttAddMsg9 = KBMINYUTTADDMSG7_9;
                    minyuttAddMsg10 = KBMINYUTTADDMSG7_10;
                    minyuttAddMsg11 = KBMINYUTTADDMSG7_11;
                    minyuttAddMsg12 = KBMINYUTTADDMSG7_12;
                    minyuttAddMsg13 = KBMINYUTTADDMSG7_13;
                    minyuttAddMsg14 = KBMINYUTTADDMSG7_14;
                    minyuttAddMsg15 = KBADDMSG_TIKIKTBRI_1;
                    minyuttAddMsg16 = KBADDMSG_TIKIKTBRI_2;
                    minyuttAddMsg17 = KBMINYUTTADDMSG7_17;
                    minyuttAddMsg18 = KBMINYUTTADDMSG7_18;
                    minyuttAddMsg19 = KBMINYUTTADDMSG7_19;
                    minyuttAddMsg20 = KBMINYUTTADDMSG7_20;
                    minyuttAddMsg21 = KBMINYUTTADDMSG7_21;
                }
                else {

                    minyuttAddMsg1 = KBMINYUTTADDMSG9_1;
                    minyuttAddMsg2 = KBMINYUTTADDMSG9_2;
                    minyuttAddMsg3 = KBMINYUTTADDMSG9_3;
                    minyuttAddMsg4 = KBMINYUTTADDMSG9_4;
                    minyuttAddMsg5 = KBMINYUTTADDMSG9_5;
                    minyuttAddMsg6 = KBMINYUTTADDMSG9_6;
                    minyuttAddMsg7 = KBMINYUTTADDMSG9_7;
                    minyuttAddMsg8 = KBMINYUTTADDMSG9_8;
                    minyuttAddMsg9 = KBMINYUTTADDMSG9_9;
                    minyuttAddMsg10 = KBMINYUTTADDMSG9_10;
                    minyuttAddMsg11 = KBMINYUTTADDMSG9_11;
                    minyuttAddMsg12 = KBMINYUTTADDMSG9_12;
                    minyuttAddMsg13 = KBMINYUTTADDMSG9_13;
                    minyuttAddMsg14 = KBMINYUTTADDMSG9_14;
                    minyuttAddMsg15 = KBMINYUTTADDMSG9_15;
                    minyuttAddMsg16 = KBADDMSG_TIKIKTBRI_1;
                    minyuttAddMsg17 = KBADDMSG_TIKIKTBRI_2;
                    minyuttAddMsg18 = KBMINYUTTADDMSG9_18;
                    minyuttAddMsg19 = KBMINYUTTADDMSG9_19;
                    minyuttAddMsg20 = KBMINYUTTADDMSG9_20;
                    minyuttAddMsg21 = KBMINYUTTADDMSG9_21;
                }
            }
        }
        else {

            if (C_UmuKbn.NONE.eq(pEditMinyuuTuutiParam.getDattaiUktkUmu()) ||
                C_UmuKbn.ARI.eq(pEditMinyuuTuutiParam.getKouzaHenkouUmuKbn())) {

                if ((!pEditMinyuuTuutiParam.getHurihunoKbn().eq(zenHurihunoKbn) &&
                    tjyMinyuRiyuuFlag) || C_UmuKbn.ARI.eq(pEditMinyuuTuutiParam.getKouzaHenkouUmuKbn())) {

                    minyuttAddMsg1 = KBMINYUTTADDMSG2_1;
                    minyuttAddMsg2 = KBMINYUTTADDMSG2_2;
                    minyuttAddMsg3 = KBMINYUTTADDMSG2_3;
                    minyuttAddMsg4 = KBMINYUTTADDMSG2_4;
                    minyuttAddMsg5 = KBMINYUTTADDMSG2_5;
                    minyuttAddMsg6 = KBMINYUTTADDMSG2_6;
                    minyuttAddMsg7 = KBMINYUTTADDMSG2_7;
                    minyuttAddMsg8 = KBMINYUTTADDMSG2_8;
                    minyuttAddMsg9 = KBMINYUTTADDMSG2_9;
                    minyuttAddMsg10 = KBMINYUTTADDMSG2_10;
                    minyuttAddMsg11 = KBMINYUTTADDMSG2_11;
                    minyuttAddMsg12 = KBMINYUTTADDMSG2_12;
                    minyuttAddMsg13 = KBMINYUTTADDMSG2_13;
                    minyuttAddMsg14 = KBMINYUTTADDMSG2_14;
                    minyuttAddMsg15 = KBMINYUTTADDMSG2_15;
                    minyuttAddMsg16 = KBMINYUTTADDMSG2_16;
                    minyuttAddMsg17 = KBMINYUTTADDMSG2_17;
                    minyuttAddMsg18 = KBMINYUTTADDMSG2_18;
                    minyuttAddMsg19 = KBMINYUTTADDMSG2_19;
                    minyuttAddMsg20 = KBADDMSG_TIKIKTBRI_1;
                    minyuttAddMsg21 = KBADDMSG_TIKIKTBRI_2;
                }
                else {

                    minyuttAddMsg1 = KBMINYUTTADDMSG12_1;
                    minyuttAddMsg2 = KBMINYUTTADDMSG12_2;
                    minyuttAddMsg3 = KBMINYUTTADDMSG12_3;
                    minyuttAddMsg4 = KBMINYUTTADDMSG12_4;
                    minyuttAddMsg5 = KBMINYUTTADDMSG12_5;
                    minyuttAddMsg6 = KBMINYUTTADDMSG12_6;
                    minyuttAddMsg7 = KBMINYUTTADDMSG12_7;
                    minyuttAddMsg8 = KBMINYUTTADDMSG12_8;
                    minyuttAddMsg9 = KBMINYUTTADDMSG12_9;
                    minyuttAddMsg10 = KBMINYUTTADDMSG12_10;
                    minyuttAddMsg11 = KBMINYUTTADDMSG12_11;
                    minyuttAddMsg12 = KBMINYUTTADDMSG12_12;
                    minyuttAddMsg13 = KBMINYUTTADDMSG12_13;
                    minyuttAddMsg14 = KBMINYUTTADDMSG12_14;
                    minyuttAddMsg15 = KBMINYUTTADDMSG12_15;
                    minyuttAddMsg16 = KBMINYUTTADDMSG12_16;
                    minyuttAddMsg17 = KBMINYUTTADDMSG12_17;
                    minyuttAddMsg18 = KBMINYUTTADDMSG12_18;
                    minyuttAddMsg19 = KBMINYUTTADDMSG12_19;
                    minyuttAddMsg20 = KBADDMSG_TIKIKTBRI_1;
                    minyuttAddMsg21 = KBADDMSG_TIKIKTBRI_2;
                }
            }
            else {

                if (C_DattairiyuuKbn.HRHENKIBOU.eq(pEditMinyuuTuutiParam.getDattaiRiyuuKbn())) {

                    minyuttAddMsg1 = KBMINYUTTADDMSG4_1;
                    minyuttAddMsg2 = KBMINYUTTADDMSG4_2;
                    minyuttAddMsg3 = KBMINYUTTADDMSG4_3;
                    minyuttAddMsg4 = KBMINYUTTADDMSG4_4;
                    minyuttAddMsg5 = KBMINYUTTADDMSG4_5;
                    minyuttAddMsg6 = KBMINYUTTADDMSG4_6;
                    minyuttAddMsg7 = KBMINYUTTADDMSG4_7;
                    minyuttAddMsg8 = KBMINYUTTADDMSG4_8;
                    minyuttAddMsg9 = KBMINYUTTADDMSG4_9;
                    minyuttAddMsg10 = KBMINYUTTADDMSG4_10;
                    minyuttAddMsg11 = KBMINYUTTADDMSG4_11;
                    minyuttAddMsg12 = KBMINYUTTADDMSG4_12;
                    minyuttAddMsg13 = KBMINYUTTADDMSG4_13;
                    minyuttAddMsg14 = KBMINYUTTADDMSG4_14;
                    minyuttAddMsg15 = KBMINYUTTADDMSG4_15;
                    minyuttAddMsg16 = KBMINYUTTADDMSG4_16;
                    minyuttAddMsg17 = KBMINYUTTADDMSG4_17;
                    minyuttAddMsg18 = KBMINYUTTADDMSG4_18;
                    minyuttAddMsg19 = KBMINYUTTADDMSG4_19;
                    minyuttAddMsg20 = KBADDMSG_TIKIKTBRI_1;
                    minyuttAddMsg21 = KBADDMSG_TIKIKTBRI_2;
                }
                else if(C_DattairiyuuKbn.KAIYAKUKIBOU.eq(pEditMinyuuTuutiParam.getDattaiRiyuuKbn())) {

                    minyuttAddMsg1 = KBMINYUTTADDMSG6_1;
                    minyuttAddMsg2 = KBMINYUTTADDMSG6_2;
                    minyuttAddMsg3 = KBMINYUTTADDMSG6_3;
                    minyuttAddMsg4 = KBMINYUTTADDMSG6_4;
                    minyuttAddMsg5 = KBMINYUTTADDMSG6_5;
                    minyuttAddMsg6 = KBMINYUTTADDMSG6_6;
                    minyuttAddMsg7 = KBMINYUTTADDMSG6_7;
                    minyuttAddMsg8 = KBMINYUTTADDMSG6_8;
                    minyuttAddMsg9 = KBMINYUTTADDMSG6_9;
                    minyuttAddMsg10 = KBMINYUTTADDMSG6_10;
                    minyuttAddMsg11 = KBMINYUTTADDMSG6_11;
                    minyuttAddMsg12 = KBMINYUTTADDMSG6_12;
                    minyuttAddMsg13 = KBMINYUTTADDMSG6_13;
                    minyuttAddMsg14 = KBMINYUTTADDMSG6_14;
                    minyuttAddMsg15 = KBMINYUTTADDMSG6_15;
                    minyuttAddMsg16 = KBMINYUTTADDMSG6_16;
                    minyuttAddMsg17 = KBMINYUTTADDMSG6_17;
                    minyuttAddMsg18 = KBMINYUTTADDMSG6_18;
                    minyuttAddMsg19 = KBMINYUTTADDMSG6_19;
                    minyuttAddMsg20 = KBADDMSG_TIKIKTBRI_1;
                    minyuttAddMsg21 = KBADDMSG_TIKIKTBRI_2;
                }
                else if (C_DattairiyuuKbn.KEIYAKUHENKOUARI.eq(pEditMinyuuTuutiParam.getDattaiRiyuuKbn())) {

                    minyuttAddMsg1 = KBMINYUTTADDMSG8_1;
                    minyuttAddMsg2 = KBMINYUTTADDMSG8_2;
                    minyuttAddMsg3 = KBMINYUTTADDMSG8_3;
                    minyuttAddMsg4 = KBMINYUTTADDMSG8_4;
                    minyuttAddMsg5 = KBMINYUTTADDMSG8_5;
                    minyuttAddMsg6 = KBMINYUTTADDMSG8_6;
                    minyuttAddMsg7 = KBMINYUTTADDMSG8_7;
                    minyuttAddMsg8 = KBMINYUTTADDMSG8_8;
                    minyuttAddMsg9 = KBMINYUTTADDMSG8_9;
                    minyuttAddMsg10 = KBMINYUTTADDMSG8_10;
                    minyuttAddMsg11 = KBMINYUTTADDMSG8_11;
                    minyuttAddMsg12 = KBMINYUTTADDMSG8_12;
                    minyuttAddMsg13 = KBMINYUTTADDMSG8_13;
                    minyuttAddMsg14 = KBMINYUTTADDMSG8_14;
                    minyuttAddMsg15 = KBMINYUTTADDMSG8_15;
                    minyuttAddMsg16 = KBMINYUTTADDMSG8_16;
                    minyuttAddMsg17 = KBMINYUTTADDMSG8_17;
                    minyuttAddMsg18 = KBMINYUTTADDMSG8_18;
                    minyuttAddMsg19 = KBMINYUTTADDMSG8_19;
                    minyuttAddMsg20 = KBADDMSG_TIKIKTBRI_1;
                    minyuttAddMsg21 = KBADDMSG_TIKIKTBRI_2;
                }
                else {

                    minyuttAddMsg1 = KBMINYUTTADDMSG10_1;
                    minyuttAddMsg2 = KBMINYUTTADDMSG10_2;
                    minyuttAddMsg3 = KBMINYUTTADDMSG10_3;
                    minyuttAddMsg4 = KBMINYUTTADDMSG10_4;
                    minyuttAddMsg5 = KBMINYUTTADDMSG10_5;
                    minyuttAddMsg6 = KBMINYUTTADDMSG10_6;
                    minyuttAddMsg7 = KBMINYUTTADDMSG10_7;
                    minyuttAddMsg8 = KBMINYUTTADDMSG10_8;
                    minyuttAddMsg9 = KBMINYUTTADDMSG10_9;
                    minyuttAddMsg10 = KBMINYUTTADDMSG10_10;
                    minyuttAddMsg11 = KBMINYUTTADDMSG10_11;
                    minyuttAddMsg12 = KBMINYUTTADDMSG10_12;
                    minyuttAddMsg13 = KBMINYUTTADDMSG10_13;
                    minyuttAddMsg14 = KBMINYUTTADDMSG10_14;
                    minyuttAddMsg15 = KBMINYUTTADDMSG10_15;
                    minyuttAddMsg16 = KBMINYUTTADDMSG10_16;
                    minyuttAddMsg17 = KBMINYUTTADDMSG10_17;
                    minyuttAddMsg18 = KBMINYUTTADDMSG10_18;
                    minyuttAddMsg19 = KBMINYUTTADDMSG10_19;
                    minyuttAddMsg20 = KBADDMSG_TIKIKTBRI_1;
                    minyuttAddMsg21 = KBADDMSG_TIKIKTBRI_2;
                }
            }
        }

        IT_KouzahuriMinyuTuuti kouzahuriMinyuTuuti = new IT_KouzahuriMinyuTuuti(pKykKihon.getSyono(), pSyoriymd);

        kouzahuriMinyuTuuti.setSyoruiCd(C_SyoruiCdKbn.AS_KOUHURIMINYUUTUUTI);
        kouzahuriMinyuTuuti.setHassoukbn(pHassouKbn);
        kouzahuriMinyuTuuti.setShskyno(kykSya.getTsinyno());
        kouzahuriMinyuTuuti.setShsadr1kj(kykSya.getTsinadr1kj());
        kouzahuriMinyuTuuti.setShsadr2kj(kykSya.getTsinadr2kj());
        kouzahuriMinyuTuuti.setShsadr3kj(kykSya.getTsinadr3kj());
        kouzahuriMinyuTuuti.setShsnmkj(kykSya.getKyknmkj());
        kouzahuriMinyuTuuti.setToiawasesosikinmkj(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikinm());
        kouzahuriMinyuTuuti.setToiawaseyno(bzGetSosikiMadogutiInfoKekkaBean.getPostalCd());
        kouzahuriMinyuTuuti.setToiawaseadr1kj(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr1());
        kouzahuriMinyuTuuti.setToiawaseadr2kj(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr2());
        kouzahuriMinyuTuuti.setToiawaseadr3kj(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr3());
        kouzahuriMinyuTuuti.setToiawasetelno(bzGetSosikiMadogutiInfoKekkaBean.getTelno());
        kouzahuriMinyuTuuti.setToiawaseteluktkkanou1(YuyuBizConfig.getInstance().getUketimecallcenter1());
        kouzahuriMinyuTuuti.setToiawaseteluktkkanou2(YuyuBizConfig.getInstance().getUketimecallcenter2());
        kouzahuriMinyuTuuti.setTuutinm30keta(tuutiNm);
        kouzahuriMinyuTuuti.setMinyuttmsg1(minyuttMsg1);
        kouzahuriMinyuTuuti.setMinyuttmsg2(minyuttMsg2);
        kouzahuriMinyuTuuti.setMinyuttmsg3(minyuttMsg3);
        kouzahuriMinyuTuuti.setMinyuttmsg4(minyuttMsg4);
        kouzahuriMinyuTuuti.setMinyuttmsg5(minyuttMsg5);
        kouzahuriMinyuTuuti.setMinyuttmsg6(minyuttMsg6);
        kouzahuriMinyuTuuti.setMinyuttmsg7(minyuttMsg7);
        kouzahuriMinyuTuuti.setMinyuttmsg8(minyuttMsg8);
        kouzahuriMinyuTuuti.setMinyuttmsg9(minyuttMsg9);
        kouzahuriMinyuTuuti.setMinyuttmsg10(minyuttMsg10);
        kouzahuriMinyuTuuti.setMinyuttmsg11(minyuttMsg11);
        kouzahuriMinyuTuuti.setMinyuttmsg12(minyuttMsg12);
        kouzahuriMinyuTuuti.setPannainm(KBPANNAINM);
        kouzahuriMinyuTuuti.setHrkhou12keta(hrkHouhou);
        kouzahuriMinyuTuuti.setHhknnmkj(hhknSya.getHhknnmkj());
        kouzahuriMinyuTuuti.setNexthurikaenaiyou1(nextHurikaeNaiyou1);
        kouzahuriMinyuTuuti.setNexthurikaenaiyou2(nextHurikaeNaiyou2);
        kouzahuriMinyuTuuti.setNexthurikaenaiyou3(nextHurikaeNaiyou3);
        kouzahuriMinyuTuuti.setSaikokutukiyykkn1(dispSaikokuTaisyouM + KBSAIKOKUKIYYKKN1);
        kouzahuriMinyuTuuti.setSaikokutukiyykkn2(KBSAIKOKUKIYYKKN2 + dispYykknMnryYmd);
        kouzahuriMinyuTuuti.setHrkmirmsg1(hrkmirMsg1);
        kouzahuriMinyuTuuti.setHrkmirmsg2(hrkmirMsg2);
        kouzahuriMinyuTuuti.setHrkmirmsg3(hrkmirMsg3);
        kouzahuriMinyuTuuti.setZenhurikaenaiyou1(zenHurikaeNaiyou1);
        kouzahuriMinyuTuuti.setZenhurikaenaiyou2(zenHurikaeNaiyou2);
        kouzahuriMinyuTuuti.setZenhurikaenaiyou3(zenHurikaeNaiyou3);
        kouzahuriMinyuTuuti.setZenhurikaenaiyou4(zenHurikaeNaiyou4);
        kouzahuriMinyuTuuti.setHurikaekz37keta1(hurikaeKz1);
        kouzahuriMinyuTuuti.setHurikaekz37keta2(hurikaeKz2);
        kouzahuriMinyuTuuti.setHurikaekz37keta3(hurikaeKz3);
        kouzahuriMinyuTuuti.setHurikaekz37keta4(hurikaeKz4);
        kouzahuriMinyuTuuti.setHurikaekz37keta5(hurikaeKz5);
        kouzahuriMinyuTuuti.setHurikaekz37keta6(hurikaeKz6);
        kouzahuriMinyuTuuti.setMinyuttaddmsg1(minyuttAddMsg1);
        kouzahuriMinyuTuuti.setMinyuttaddmsg2(minyuttAddMsg2);
        kouzahuriMinyuTuuti.setMinyuttaddmsg3(minyuttAddMsg3);
        kouzahuriMinyuTuuti.setMinyuttaddmsg4(minyuttAddMsg4);
        kouzahuriMinyuTuuti.setMinyuttaddmsg5(minyuttAddMsg5);
        kouzahuriMinyuTuuti.setMinyuttaddmsg6(minyuttAddMsg6);
        kouzahuriMinyuTuuti.setMinyuttaddmsg7(minyuttAddMsg7);
        kouzahuriMinyuTuuti.setMinyuttaddmsg8(minyuttAddMsg8);
        kouzahuriMinyuTuuti.setMinyuttaddmsg9(minyuttAddMsg9);
        kouzahuriMinyuTuuti.setMinyuttaddmsg10(minyuttAddMsg10);
        kouzahuriMinyuTuuti.setMinyuttaddmsg11(minyuttAddMsg11);
        kouzahuriMinyuTuuti.setMinyuttaddmsg12(minyuttAddMsg12);
        kouzahuriMinyuTuuti.setMinyuttaddmsg13(minyuttAddMsg13);
        kouzahuriMinyuTuuti.setMinyuttaddmsg14(minyuttAddMsg14);
        kouzahuriMinyuTuuti.setMinyuttaddmsg15(minyuttAddMsg15);
        kouzahuriMinyuTuuti.setMinyuttaddmsg16(minyuttAddMsg16);
        kouzahuriMinyuTuuti.setMinyuttaddmsg17(minyuttAddMsg17);
        kouzahuriMinyuTuuti.setMinyuttaddmsg18(minyuttAddMsg18);
        kouzahuriMinyuTuuti.setMinyuttaddmsg19(minyuttAddMsg19);
        kouzahuriMinyuTuuti.setMinyuttaddmsg20(minyuttAddMsg20);
        kouzahuriMinyuTuuti.setMinyuttaddmsg21(minyuttAddMsg21);
        kouzahuriMinyuTuuti.setTuutisyuruicd(pTuutisyuruicd);
        kouzahuriMinyuTuuti.setSaikokutuutizumiflg(saikokuTuutiZumiflg);
        kouzahuriMinyuTuuti.setTyouhyoukigoukbn(C_AsTyouhyoukigouKbn.AS_KOUHURIMINYUUTUUTI);
        kouzahuriMinyuTuuti.setHrkkeiro(C_Hrkkeiro.KOUHURI);
        kouzahuriMinyuTuuti.setJkipjytym(pEditMinyuuTuutiParam.getJkiPJytYm());
        kouzahuriMinyuTuuti.setGyoumuKousinKinou(pKhozenCommonParam.getFunctionId());
        kouzahuriMinyuTuuti.setGyoumuKousinsyaId(pKhozenCommonParam.getUserID());
        kouzahuriMinyuTuuti.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

        BizPropertyInitializer.initialize(kouzahuriMinyuTuuti);
        return kouzahuriMinyuTuuti;
    }

    public IT_KouzahuriMinyuTuuti editTBL(KhozenCommonParam pKhozenCommonParam,
        IT_KykKihon pKykKihon,
        SaikokuTuutiParam pSaikokuTuutiParam,
        BizDate pSyoriymd,
        C_HassouKbn pHassouKbn,
        String pTuutisyuruicd) {

        String tuutiNm = "";
        String  minyuttMsg1 = "";
        String  minyuttMsg2 = "";
        String  minyuttMsg3 = "";
        String  minyuttMsg4 = "";
        String  minyuttMsg5 = "";
        String  minyuttMsg6 = "";
        String  minyuttMsg7 = "";
        String  minyuttMsg8 = "";
        String  minyuttMsg9 = "";
        String  minyuttMsg10 = "";
        String  minyuttMsg11 = "";
        String  minyuttMsg12 = "";
        String hrkHouhou = "";
        String nextHurikaeNaiyou1 = "";
        String nextHurikaeNaiyou2 = "";
        String nextHurikaeNaiyou3 = "";
        String hrkmirMsg1 = "";
        String hrkmirMsg2 = "";
        String hrkmirMsg3 = "";
        String hurikaeKz1 = "";
        String hurikaeKz2 = "";
        String hurikaeKz3 = "";
        String hurikaeKz4 = "";
        String hurikaeKz5 = "";
        String hurikaeKz6 = "";
        String minyuttAddMsg1 = "";
        String minyuttAddMsg2 = "";
        String minyuttAddMsg3 = "";
        String minyuttAddMsg4 = "";
        String minyuttAddMsg5 = "";
        String minyuttAddMsg6 = "";
        String minyuttAddMsg7 = "";
        String minyuttAddMsg8 = "";
        String minyuttAddMsg9 = "";
        String minyuttAddMsg10 = "";
        String minyuttAddMsg11 = "";
        String minyuttAddMsg12 = "";
        String minyuttAddMsg13 = "";
        String minyuttAddMsg14 = "";
        String minyuttAddMsg15 = "";
        String minyuttAddMsg16 = "";
        String minyuttAddMsg17 = "";
        String minyuttAddMsg18 = "";
        String minyuttAddMsg19 = "";
        String minyuttAddMsg20 = "";
        String minyuttAddMsg21 = "";

        IT_KykSya kykSya = pKykKihon.getKykSya();
        IT_HhknSya hhknSya = pKykKihon.getHhknSya();

        BzGetSosikiMadogutiInfo bzGetSosikiMadogutiInfo = SWAKInjector.getInstance(BzGetSosikiMadogutiInfo.class);
        BzGetSosikiMadogutiInfoKekkaBean bzGetSosikiMadogutiInfoKekkaBean =
            bzGetSosikiMadogutiInfo.exec(YuyuBizConfig.getInstance().getCallcentersosikicd());

        BizDate jkiHurikaeYmdZnegyb = pSaikokuTuutiParam.getJkiHurikaeYmd().addBusinessDays(-1);
        String dispJkiHurikaeYmdZnegyb = FixedDateFormatter.formatYMDZenkakuSeirekiKanji(jkiHurikaeYmdZnegyb);

        BizDateYM nextRyosyuYm = null;
        if (pSaikokuTuutiParam.getJkiHurikaeYmd().getDay() < 27) {
            nextRyosyuYm = pSaikokuTuutiParam.getJkiHurikaeYmd().getBizDateYM().getPreviousMonth();
        }
        else {
            nextRyosyuYm = pSaikokuTuutiParam.getJkiHurikaeYmd().getBizDateYM();
        }

        String dispYykknMnryYmd = FixedDateFormatter.formatYMDZenkakuSeirekiKanji(pSaikokuTuutiParam.getYykknMnryYmd());

        String dispJkiPJytYm = FixedDateFormatter.formatYMZenkakuSeirekiKanji(pSaikokuTuutiParam.getJkiPJytYm().getFirstDay());

        String dispSaikokuTaisyouM = FixedDateFormatter.formatMZenkakuKanji(pSaikokuTuutiParam.getJkiPJytYm().getFirstDay());

        String dispJkiHurikaeM = FixedDateFormatter.formatMZenkakuKanji(nextRyosyuYm.getFirstDay());

        String dispJkiAnnaiJyuutouTukisuu = Strings.padStart(
            ConvertUtil.toZenNumeric(String.valueOf(pSaikokuTuutiParam.getJkiAnnaiJyuutouTukisuu())), 2, '　');

        String dispJkiAnnaiKg = Strings.padStart(
            ConvertUtil.toZenAll(BizUtil.comma(pSaikokuTuutiParam.getJkiAnnaiKg().toAdsoluteString()), 0, 0), 11, '　');

        String dispJkiHurikaeYmd = FixedDateFormatter.formatYMDZenkakuSeirekiKanji(pSaikokuTuutiParam.getJkiHurikaeYmd());

        tuutiNm = KBTUUTINM2;

        if (C_UmuKbn.NONE.eq(pSaikokuTuutiParam.getDattaiUktkUmu())) {
            minyuttMsg1 = KBOSIRASEMSGCD5_1;
            minyuttMsg2 = KBOSIRASEMSGCD5_2_1 + dispJkiPJytYm + KBOSIRASEMSGCD5_2_2;
            minyuttMsg3 = KBOSIRASEMSGCD5_3;
            minyuttMsg4 = KBOSIRASEMSGCD5_4_1 + dispJkiHurikaeM + KBOSIRASEMSGCD5_4_2;
            minyuttMsg5 = KBOSIRASEMSGCD5_5_1 + dispJkiHurikaeYmdZnegyb + KBOSIRASEMSGCD5_5_2;
            minyuttMsg6 = KBOSIRASEMSGCD5_6;
            minyuttMsg7 = KBOSIRASEMSGCD5_7;
            minyuttMsg8 = KBOSIRASEMSG_HRKKIGEN_5;
            minyuttMsg9 = KBOSIRASEMSGCD5_9;
            minyuttMsg10 = KBOSIRASEMSGCD5_10;
            minyuttMsg11 = KBOSIRASEMSGCD5_11;
            minyuttMsg12 = KBOSIRASEMSGCD5_12;
        }
        else {
            if (C_UmuKbn.ARI.eq(pSaikokuTuutiParam.getSyuunoujiDattaiUmuKbn())) {

                minyuttMsg1 = KBOSIRASEMSGCD3_1;
                minyuttMsg2 = KBOSIRASEMSGCD3_2;
                minyuttMsg3 = KBOSIRASEMSGCD3_3_1 + dispJkiPJytYm + KBOSIRASEMSGCD3_3_2;
                minyuttMsg4 = KBOSIRASEMSGCD3_4;
                minyuttMsg5 = KBOSIRASEMSG_HRKKIGEN_1;
                minyuttMsg6 = KBOSIRASEMSG_HRKKIGEN_2;
                minyuttMsg7 = KBOSIRASEMSGCD3_7;
                minyuttMsg8 = KBOSIRASEMSG_HRKKIGEN_3;
                minyuttMsg9 = KBOSIRASEMSG_HRKKIGEN_4;
                minyuttMsg10 = KBOSIRASEMSGCD3_10;
                minyuttMsg11 = KBOSIRASEMSGCD3_11;
                minyuttMsg12 = KBOSIRASEMSGCD3_12;
            }
            else {
                if (C_DattairiyuuKbn.HRHENKIBOU.eq(pSaikokuTuutiParam.getDattaiRiyuuKbn())) {

                    minyuttMsg1 = KBOSIRASEMSGCD1_1;
                    minyuttMsg2 = KBOSIRASEMSGCD1_2;
                    minyuttMsg3 = KBOSIRASEMSGCD1_3_1 + dispJkiPJytYm + KBOSIRASEMSGCD1_3_2;
                    minyuttMsg4 = KBOSIRASEMSGCD1_4;
                    minyuttMsg5 = KBOSIRASEMSGCD1_5;
                    minyuttMsg6 = KBOSIRASEMSG_HRKKIGEN_1;
                    minyuttMsg7 = KBOSIRASEMSG_HRKKIGEN_2;
                    minyuttMsg8 = KBOSIRASEMSGCD1_8;
                    minyuttMsg9 = KBOSIRASEMSG_HRKKIGEN_3;
                    minyuttMsg10 = KBOSIRASEMSG_HRKKIGEN_4;
                    minyuttMsg11 = KBOSIRASEMSGCD1_11;
                    minyuttMsg12 = KBOSIRASEMSGCD1_12;
                }
                else if(C_DattairiyuuKbn.KAIYAKUKIBOU.eq(pSaikokuTuutiParam.getDattaiRiyuuKbn())) {

                    minyuttMsg1 = KBOSIRASEMSGCD2_1;
                    minyuttMsg2 = KBOSIRASEMSGCD2_2;
                    minyuttMsg3 = KBOSIRASEMSGCD2_3_1 + dispJkiPJytYm + KBOSIRASEMSGCD2_3_2;
                    minyuttMsg4 = KBOSIRASEMSGCD2_4;
                    minyuttMsg5 = KBOSIRASEMSG_HRKKIGEN_1;
                    minyuttMsg6 = KBOSIRASEMSG_HRKKIGEN_2;
                    minyuttMsg7 = KBOSIRASEMSGCD2_7;
                    minyuttMsg8 = KBOSIRASEMSG_HRKKIGEN_3;
                    minyuttMsg9 = KBOSIRASEMSG_HRKKIGEN_4;
                    minyuttMsg10 = KBOSIRASEMSGCD2_10;
                    minyuttMsg11 = KBOSIRASEMSGCD2_11;
                    minyuttMsg12 = KBOSIRASEMSGCD2_12;
                }
                else if (C_DattairiyuuKbn.KEIYAKUHENKOUARI.eq(pSaikokuTuutiParam.getDattaiRiyuuKbn())) {

                    minyuttMsg1 = KBOSIRASEMSGCD4_1;
                    minyuttMsg2 = KBOSIRASEMSGCD4_2;
                    minyuttMsg3 = KBOSIRASEMSGCD4_3_1 + dispJkiPJytYm + KBOSIRASEMSGCD4_3_2;
                    minyuttMsg4 = KBOSIRASEMSGCD4_4;
                    minyuttMsg5 = KBOSIRASEMSGCD4_5;
                    minyuttMsg6 = KBOSIRASEMSG_HRKKIGEN_1;
                    minyuttMsg7 = KBOSIRASEMSG_HRKKIGEN_2;
                    minyuttMsg8 = KBOSIRASEMSGCD4_8;
                    minyuttMsg9 = KBOSIRASEMSG_HRKKIGEN_3;
                    minyuttMsg10 = KBOSIRASEMSG_HRKKIGEN_4;
                    minyuttMsg11 = KBOSIRASEMSGCD4_11;
                    minyuttMsg12 = KBOSIRASEMSGCD4_12;
                }
                else {

                    minyuttMsg1 = KBOSIRASEMSGCD3_1;
                    minyuttMsg2 = KBOSIRASEMSGCD3_2;
                    minyuttMsg3 = KBOSIRASEMSGCD3_3_1 + dispJkiPJytYm + KBOSIRASEMSGCD3_3_2;
                    minyuttMsg4 = KBOSIRASEMSGCD3_4;
                    minyuttMsg5 = KBOSIRASEMSG_HRKKIGEN_1;
                    minyuttMsg6 = KBOSIRASEMSG_HRKKIGEN_2;
                    minyuttMsg7 = KBOSIRASEMSGCD3_7;
                    minyuttMsg8 = KBOSIRASEMSG_HRKKIGEN_3;
                    minyuttMsg9 = KBOSIRASEMSG_HRKKIGEN_4;
                    minyuttMsg10 = KBOSIRASEMSGCD3_10;
                    minyuttMsg11 = KBOSIRASEMSGCD3_11;
                    minyuttMsg12 = KBOSIRASEMSGCD3_12;
                }
            }
        }

        if (C_Hrkkaisuu.TUKI.eq(pKykKihon.getHrkkaisuu())) {

            if (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(pKykKihon.getTikiktbrisyuruikbn()) ||
                C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(pKykKihon.getTikiktbrisyuruikbn())) {

                hrkHouhou = pKykKihon.getTikiktbrisyuruikbn().getContent() + "払";
            }
            else {

                hrkHouhou = pKykKihon.getHrkkaisuu().getContent();
            }
        }

        if (C_UmuKbn.NONE.eq(pSaikokuTuutiParam.getDattaiUktkUmu())) {

            nextHurikaeNaiyou1 = KBNEXTHURIKAEMAIYOU2_1;
            nextHurikaeNaiyou2 = dispJkiHurikaeM + KBNEXTHURIKAEMAIYOU2_2_1 + dispJkiHurikaeYmd + KBNEXTHURIKAEMAIYOU2_2_2;
            nextHurikaeNaiyou3 = KBNEXTHURIKAEMAIYOU2_3_1 + dispJkiAnnaiKg + KBNEXTHURIKAEMAIYOU2_3_2  +
                dispJkiPJytYm + KBNEXTHURIKAEMAIYOU2_3_3  + dispJkiAnnaiJyuutouTukisuu + KBNEXTHURIKAEMAIYOU2_3_4;
        }
        else {

            nextHurikaeNaiyou1 = KBNEXTHURIKAEMAIYOU1_1;
            nextHurikaeNaiyou2 = KBNEXTHURIKAEMAIYOU1_2_1 + dispJkiAnnaiKg + KBNEXTHURIKAEMAIYOU1_2_2 +
                dispJkiPJytYm + KBNEXTHURIKAEMAIYOU1_2_3  + dispJkiAnnaiJyuutouTukisuu + KBNEXTHURIKAEMAIYOU1_2_4;
            nextHurikaeNaiyou3 = KBNEXTHURIKAEMAIYOU1_3;
        }

        if (C_UmuKbn.NONE.eq(pSaikokuTuutiParam.getDattaiUktkUmu())) {

            hrkmirMsg1 = KBHRKMIRMSG1_1 + dispJkiHurikaeYmd + KBHRKMIRMSG1_2;
            hrkmirMsg2 = KBHRKMIRMSG_HRKKIGEN_1 + dispYykknMnryYmd + KBHRKMIRMSG2_2;
            hrkmirMsg3 = KBHRKMIRMSG3;
        }

        IT_Kouza kouza = pKykKihon.getKouza();

        BzGetBankData bzGetBankData = SWAKInjector.getInstance(BzGetBankData.class);
        BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(kouza.getBankcd(), kouza.getSitencd());

        String bankNmKj = bzGetBankDataBean.getBankNmKj();
        String sitenNmKj = bzGetBankDataBean.getReportSitenNm();

        String updKouzaNo = ConvertUtil.toZenAll(KhozenEdit.editKouzaNo(kouza.getBankcd(), kouza.getKouzano()), 0, 0);

        if (IGkCommonKoumoku.BANKCD_YTGINKOU.equals(kouza.getBankcd())) {

            hurikaeKz1 = KBHURIKAEKZ1_1;
            hurikaeKz2 = bankNmKj;
            hurikaeKz3 = sitenNmKj;
            hurikaeKz4 = KBHURIKAEKZ1_4 + updKouzaNo;
            hurikaeKz5 = KBHURIKAEKZ1_5_1 + kouza.getKzmeiginmkn() + KBHURIKAEKZ1_5_2;
            hurikaeKz6 = KBHURIKAEKZ1_6;
        }
        else {

            hurikaeKz1 = KBHURIKAEKZ2_1;
            hurikaeKz2 = bankNmKj;
            hurikaeKz3 = sitenNmKj;
            hurikaeKz4 = kouza.getYokinkbn().getContent(C_YokinKbn.PATTERN_TYOUHYOU) +
                KBHURIKAEKZ2_4_2 + updKouzaNo;
            hurikaeKz5 = KBHURIKAEKZ2_5_1 + kouza.getKzmeiginmkn() + KBHURIKAEKZ2_5_2;
            hurikaeKz6 = KBHURIKAEKZ2_6;
        }

        if (C_UmuKbn.NONE.eq(pSaikokuTuutiParam.getDattaiUktkUmu())) {


            minyuttAddMsg1 = KBMINYUTTADDMSG2_1;
            minyuttAddMsg2 = KBADDMSG_HRKKIGEN_1;
            minyuttAddMsg3 = KBADDMSG_HRKKIGEN_2;
            minyuttAddMsg4 = KB_BLANK;
            minyuttAddMsg5 = KBMINYUTTADDMSG2_5;
            minyuttAddMsg6 = KBADDMSG_HRKKIGEN_3;
            minyuttAddMsg7 = KBADDMSG_HRKKIGEN_4;
            minyuttAddMsg8 = KBMINYUTTADDMSG2_8;
            minyuttAddMsg9 = KBMINYUTTADDMSG2_9;
            minyuttAddMsg10 = KBMINYUTTADDMSG2_10;
            minyuttAddMsg11 = KBMINYUTTADDMSG2_11;
            minyuttAddMsg12 = KBMINYUTTADDMSG2_12;
            minyuttAddMsg13 = KBMINYUTTADDMSG2_13;
            minyuttAddMsg14 = KBMINYUTTADDMSG2_14;
            minyuttAddMsg15 = KBMINYUTTADDMSG2_15;
            minyuttAddMsg16 = KBMINYUTTADDMSG2_16;
            minyuttAddMsg17 = KBMINYUTTADDMSG2_17;
            minyuttAddMsg18 = KBMINYUTTADDMSG2_18;
            minyuttAddMsg19 = KBMINYUTTADDMSG2_19;
            minyuttAddMsg20 = KBADDMSG_TIKIKTBRI_1;
            minyuttAddMsg21 = KBADDMSG_TIKIKTBRI_2;
        }
        else {
            if(C_UmuKbn.ARI.eq(pSaikokuTuutiParam.getSyuunoujiDattaiUmuKbn())){

                minyuttAddMsg1 = KBADDMSG_HRKKIGEN_1;
                minyuttAddMsg2 = KBADDMSG_HRKKIGEN_2;
                minyuttAddMsg3 = KB_BLANK;
                minyuttAddMsg4 = KBMINYUTTADDMSG12_4;
                minyuttAddMsg5 = KBADDMSG_HRKKIGEN_3;
                minyuttAddMsg6 = KBADDMSG_HRKKIGEN_4;
                minyuttAddMsg7 = KBMINYUTTADDMSG12_7;
                minyuttAddMsg8 = KBMINYUTTADDMSG12_8;
                minyuttAddMsg9 = KBMINYUTTADDMSG12_9;
                minyuttAddMsg10 = KBMINYUTTADDMSG12_10;
                minyuttAddMsg11 = KBMINYUTTADDMSG12_11;
                minyuttAddMsg12 = KBMINYUTTADDMSG12_12;
                minyuttAddMsg13 = KBMINYUTTADDMSG12_13;
                minyuttAddMsg14 = KBMINYUTTADDMSG12_14;
                minyuttAddMsg15 = KBMINYUTTADDMSG12_15;
                minyuttAddMsg16 = KBMINYUTTADDMSG12_16;
                minyuttAddMsg17 = KBMINYUTTADDMSG12_17;
                minyuttAddMsg18 = KBMINYUTTADDMSG12_18;
                minyuttAddMsg19 = KBMINYUTTADDMSG12_19;
                minyuttAddMsg20 = KBADDMSG_TIKIKTBRI_1;
                minyuttAddMsg21 = KBADDMSG_TIKIKTBRI_2;
            }
            else {

                if (C_DattairiyuuKbn.HRHENKIBOU.eq(pSaikokuTuutiParam.getDattaiRiyuuKbn())) {

                    minyuttAddMsg1 = KBMINYUTTADDMSG4_1;
                    minyuttAddMsg2 = KBADDMSG_HRKKIGEN_1;
                    minyuttAddMsg3 = KBADDMSG_HRKKIGEN_2;
                    minyuttAddMsg4 = KB_BLANK;
                    minyuttAddMsg5 = KBMINYUTTADDMSG4_5;
                    minyuttAddMsg6 = KBMINYUTTADDMSG4_6;
                    minyuttAddMsg7 = KBMINYUTTADDMSG4_7;
                    minyuttAddMsg8 = KBMINYUTTADDMSG4_8;
                    minyuttAddMsg9 = KBMINYUTTADDMSG4_9;
                    minyuttAddMsg10 = KBMINYUTTADDMSG4_10;
                    minyuttAddMsg11 = KBMINYUTTADDMSG4_11;
                    minyuttAddMsg12 = KBMINYUTTADDMSG4_12;
                    minyuttAddMsg13 = KBMINYUTTADDMSG4_13;
                    minyuttAddMsg14 = KBMINYUTTADDMSG4_14;
                    minyuttAddMsg15 = KBMINYUTTADDMSG4_15;
                    minyuttAddMsg16 = KBMINYUTTADDMSG4_16;
                    minyuttAddMsg17 = KBMINYUTTADDMSG4_17;
                    minyuttAddMsg18 = KBMINYUTTADDMSG4_18;
                    minyuttAddMsg19 = KBMINYUTTADDMSG4_19;
                    minyuttAddMsg20 = KBADDMSG_TIKIKTBRI_1;
                    minyuttAddMsg21 = KBADDMSG_TIKIKTBRI_2;
                }
                else if(C_DattairiyuuKbn.KAIYAKUKIBOU.eq(pSaikokuTuutiParam.getDattaiRiyuuKbn())) {

                    minyuttAddMsg1 = KBMINYUTTADDMSG6_1;
                    minyuttAddMsg2 = KBADDMSG_HRKKIGEN_1;
                    minyuttAddMsg3 = KBADDMSG_HRKKIGEN_2;
                    minyuttAddMsg4 = KB_BLANK;
                    minyuttAddMsg5 = KBMINYUTTADDMSG6_5;
                    minyuttAddMsg6 = KBMINYUTTADDMSG6_6;
                    minyuttAddMsg7 = KBMINYUTTADDMSG6_7;
                    minyuttAddMsg8 = KBMINYUTTADDMSG6_8;
                    minyuttAddMsg9 = KBMINYUTTADDMSG6_9;
                    minyuttAddMsg10 = KBMINYUTTADDMSG6_10;
                    minyuttAddMsg11 = KBMINYUTTADDMSG6_11;
                    minyuttAddMsg12 = KBMINYUTTADDMSG6_12;
                    minyuttAddMsg13 = KBMINYUTTADDMSG6_13;
                    minyuttAddMsg14 = KBMINYUTTADDMSG6_14;
                    minyuttAddMsg15 = KBADDMSG_HRKKIGEN_5;
                    minyuttAddMsg16 = KBADDMSG_HRKKIGEN_6;
                    minyuttAddMsg17 = KBADDMSG_HRKKIGEN_7;
                    minyuttAddMsg18 = KBMINYUTTADDMSG6_18;
                    minyuttAddMsg19 = KBMINYUTTADDMSG6_19;
                    minyuttAddMsg20 = KBADDMSG_TIKIKTBRI_1;
                    minyuttAddMsg21 = KBADDMSG_TIKIKTBRI_2;
                }
                else if (C_DattairiyuuKbn.KEIYAKUHENKOUARI.eq(pSaikokuTuutiParam.getDattaiRiyuuKbn())) {

                    minyuttAddMsg1 = KBMINYUTTADDMSG8_1;
                    minyuttAddMsg2 = KBADDMSG_HRKKIGEN_1;
                    minyuttAddMsg3 = KBADDMSG_HRKKIGEN_2;
                    minyuttAddMsg4 = KB_BLANK;
                    minyuttAddMsg5 = KBMINYUTTADDMSG8_5;
                    minyuttAddMsg6 = KBMINYUTTADDMSG8_6;
                    minyuttAddMsg7 = KBMINYUTTADDMSG8_7;
                    minyuttAddMsg8 = KBMINYUTTADDMSG8_8;
                    minyuttAddMsg9 = KBMINYUTTADDMSG8_9;
                    minyuttAddMsg10 = KBMINYUTTADDMSG8_10;
                    minyuttAddMsg11 = KBMINYUTTADDMSG8_11;
                    minyuttAddMsg12 = KBMINYUTTADDMSG8_12;
                    minyuttAddMsg13 = KBMINYUTTADDMSG8_13;
                    minyuttAddMsg14 = KBMINYUTTADDMSG8_14;
                    minyuttAddMsg15 = KBMINYUTTADDMSG8_15;
                    minyuttAddMsg16 = KBMINYUTTADDMSG8_16;
                    minyuttAddMsg17 = KBMINYUTTADDMSG8_17;
                    minyuttAddMsg18 = KBMINYUTTADDMSG8_18;
                    minyuttAddMsg19 = KBMINYUTTADDMSG8_19;
                    minyuttAddMsg20 = KBADDMSG_TIKIKTBRI_1;
                    minyuttAddMsg21 = KBADDMSG_TIKIKTBRI_2;
                }
                else {

                    minyuttAddMsg1 = KBMINYUTTADDMSG10_1;
                    minyuttAddMsg2 = KBADDMSG_HRKKIGEN_1;
                    minyuttAddMsg3 = KBADDMSG_HRKKIGEN_2;
                    minyuttAddMsg4 = KB_BLANK;
                    minyuttAddMsg5 = KBMINYUTTADDMSG10_5;
                    minyuttAddMsg6 = KBADDMSG_HRKKIGEN_3;
                    minyuttAddMsg7 = KBADDMSG_HRKKIGEN_4;
                    minyuttAddMsg8 = KBMINYUTTADDMSG10_8;
                    minyuttAddMsg9 = KBMINYUTTADDMSG10_9;
                    minyuttAddMsg10 = KBMINYUTTADDMSG10_10;
                    minyuttAddMsg11 = KBMINYUTTADDMSG10_11;
                    minyuttAddMsg12 = KBMINYUTTADDMSG10_12;
                    minyuttAddMsg13 = KBMINYUTTADDMSG10_13;
                    minyuttAddMsg14 = KBMINYUTTADDMSG10_14;
                    minyuttAddMsg15 = KBMINYUTTADDMSG10_15;
                    minyuttAddMsg16 = KBMINYUTTADDMSG10_16;
                    minyuttAddMsg17 = KBMINYUTTADDMSG10_17;
                    minyuttAddMsg18 = KBMINYUTTADDMSG10_18;
                    minyuttAddMsg19 = KBMINYUTTADDMSG10_19;
                    minyuttAddMsg20 = KBADDMSG_TIKIKTBRI_1;
                    minyuttAddMsg21 = KBADDMSG_TIKIKTBRI_2;
                }
            }
        }

        IT_KouzahuriMinyuTuuti kouzahuriMinyuTuuti = new IT_KouzahuriMinyuTuuti(pKykKihon.getSyono(), pSyoriymd);

        kouzahuriMinyuTuuti.setSyoruiCd(C_SyoruiCdKbn.AS_KOUHURIMINYUUTUUTI);
        kouzahuriMinyuTuuti.setHassoukbn(pHassouKbn);
        kouzahuriMinyuTuuti.setShskyno(kykSya.getTsinyno());
        kouzahuriMinyuTuuti.setShsadr1kj(kykSya.getTsinadr1kj());
        kouzahuriMinyuTuuti.setShsadr2kj(kykSya.getTsinadr2kj());
        kouzahuriMinyuTuuti.setShsadr3kj(kykSya.getTsinadr3kj());
        kouzahuriMinyuTuuti.setShsnmkj(kykSya.getKyknmkj());
        kouzahuriMinyuTuuti.setToiawasesosikinmkj(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikinm());
        kouzahuriMinyuTuuti.setToiawaseyno(bzGetSosikiMadogutiInfoKekkaBean.getPostalCd());
        kouzahuriMinyuTuuti.setToiawaseadr1kj(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr1());
        kouzahuriMinyuTuuti.setToiawaseadr2kj(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr2());
        kouzahuriMinyuTuuti.setToiawaseadr3kj(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr3());
        kouzahuriMinyuTuuti.setToiawasetelno(bzGetSosikiMadogutiInfoKekkaBean.getTelno());
        kouzahuriMinyuTuuti.setToiawaseteluktkkanou1(YuyuBizConfig.getInstance().getUketimecallcenter1());
        kouzahuriMinyuTuuti.setToiawaseteluktkkanou2(YuyuBizConfig.getInstance().getUketimecallcenter2());
        kouzahuriMinyuTuuti.setTuutinm30keta(tuutiNm);
        kouzahuriMinyuTuuti.setMinyuttmsg1(minyuttMsg1);
        kouzahuriMinyuTuuti.setMinyuttmsg2(minyuttMsg2);
        kouzahuriMinyuTuuti.setMinyuttmsg3(minyuttMsg3);
        kouzahuriMinyuTuuti.setMinyuttmsg4(minyuttMsg4);
        kouzahuriMinyuTuuti.setMinyuttmsg5(minyuttMsg5);
        kouzahuriMinyuTuuti.setMinyuttmsg6(minyuttMsg6);
        kouzahuriMinyuTuuti.setMinyuttmsg7(minyuttMsg7);
        kouzahuriMinyuTuuti.setMinyuttmsg8(minyuttMsg8);
        kouzahuriMinyuTuuti.setMinyuttmsg9(minyuttMsg9);
        kouzahuriMinyuTuuti.setMinyuttmsg10(minyuttMsg10);
        kouzahuriMinyuTuuti.setMinyuttmsg11(minyuttMsg11);
        kouzahuriMinyuTuuti.setMinyuttmsg12(minyuttMsg12);
        kouzahuriMinyuTuuti.setPannainm(KBPANNAINM);
        kouzahuriMinyuTuuti.setHrkhou12keta(hrkHouhou);
        kouzahuriMinyuTuuti.setHhknnmkj(hhknSya.getHhknnmkj());
        kouzahuriMinyuTuuti.setNexthurikaenaiyou1(nextHurikaeNaiyou1);
        kouzahuriMinyuTuuti.setNexthurikaenaiyou2(nextHurikaeNaiyou2);
        kouzahuriMinyuTuuti.setNexthurikaenaiyou3(nextHurikaeNaiyou3);
        kouzahuriMinyuTuuti.setSaikokutukiyykkn1(dispSaikokuTaisyouM + KBSAIKOKUKIYYKKN_HRKKIGEN_1);
        kouzahuriMinyuTuuti.setSaikokutukiyykkn2(KBSAIKOKUKIYYKKN2 + dispYykknMnryYmd);
        kouzahuriMinyuTuuti.setHrkmirmsg1(hrkmirMsg1);
        kouzahuriMinyuTuuti.setHrkmirmsg2(hrkmirMsg2);
        kouzahuriMinyuTuuti.setHrkmirmsg3(hrkmirMsg3);
        kouzahuriMinyuTuuti.setHurikaekz37keta1(hurikaeKz1);
        kouzahuriMinyuTuuti.setHurikaekz37keta2(hurikaeKz2);
        kouzahuriMinyuTuuti.setHurikaekz37keta3(hurikaeKz3);
        kouzahuriMinyuTuuti.setHurikaekz37keta4(hurikaeKz4);
        kouzahuriMinyuTuuti.setHurikaekz37keta5(hurikaeKz5);
        kouzahuriMinyuTuuti.setHurikaekz37keta6(hurikaeKz6);
        kouzahuriMinyuTuuti.setMinyuttaddmsg1(minyuttAddMsg1);
        kouzahuriMinyuTuuti.setMinyuttaddmsg2(minyuttAddMsg2);
        kouzahuriMinyuTuuti.setMinyuttaddmsg3(minyuttAddMsg3);
        kouzahuriMinyuTuuti.setMinyuttaddmsg4(minyuttAddMsg4);
        kouzahuriMinyuTuuti.setMinyuttaddmsg5(minyuttAddMsg5);
        kouzahuriMinyuTuuti.setMinyuttaddmsg6(minyuttAddMsg6);
        kouzahuriMinyuTuuti.setMinyuttaddmsg7(minyuttAddMsg7);
        kouzahuriMinyuTuuti.setMinyuttaddmsg8(minyuttAddMsg8);
        kouzahuriMinyuTuuti.setMinyuttaddmsg9(minyuttAddMsg9);
        kouzahuriMinyuTuuti.setMinyuttaddmsg10(minyuttAddMsg10);
        kouzahuriMinyuTuuti.setMinyuttaddmsg11(minyuttAddMsg11);
        kouzahuriMinyuTuuti.setMinyuttaddmsg12(minyuttAddMsg12);
        kouzahuriMinyuTuuti.setMinyuttaddmsg13(minyuttAddMsg13);
        kouzahuriMinyuTuuti.setMinyuttaddmsg14(minyuttAddMsg14);
        kouzahuriMinyuTuuti.setMinyuttaddmsg15(minyuttAddMsg15);
        kouzahuriMinyuTuuti.setMinyuttaddmsg16(minyuttAddMsg16);
        kouzahuriMinyuTuuti.setMinyuttaddmsg17(minyuttAddMsg17);
        kouzahuriMinyuTuuti.setMinyuttaddmsg18(minyuttAddMsg18);
        kouzahuriMinyuTuuti.setMinyuttaddmsg19(minyuttAddMsg19);
        kouzahuriMinyuTuuti.setMinyuttaddmsg20(minyuttAddMsg20);
        kouzahuriMinyuTuuti.setMinyuttaddmsg21(minyuttAddMsg21);
        kouzahuriMinyuTuuti.setTuutisyuruicd(pTuutisyuruicd);
        kouzahuriMinyuTuuti.setSaikokutuutizumiflg(C_Skszumiflg.SAKUSEIZUMI);
        kouzahuriMinyuTuuti.setTyouhyoukigoukbn(C_AsTyouhyoukigouKbn.AS_SAIKOKUTUUTI);
        kouzahuriMinyuTuuti.setHrkkeiro(C_Hrkkeiro.KOUHURI);
        kouzahuriMinyuTuuti.setJkipjytym(pSaikokuTuutiParam.getJkiPJytYm());
        kouzahuriMinyuTuuti.setGyoumuKousinKinou(pKhozenCommonParam.getFunctionId());
        kouzahuriMinyuTuuti.setGyoumuKousinsyaId(pKhozenCommonParam.getUserID());
        kouzahuriMinyuTuuti.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

        BizPropertyInitializer.initialize(kouzahuriMinyuTuuti);
        return kouzahuriMinyuTuuti;
    }

    public IT_KouzahuriMinyuTuuti editTBL(KhozenCommonParam pKhozenCommonParam,
        IT_KykKihon pKykKihon,
        EditCreditMinyuuTuutiParam pEditCreditMinyuuTuutiParam,
        BizDate pSyoriymd,
        C_HassouKbn pHassouKbn,
        String pTuutisyuruicd) {

        String tuutiNm = "";
        C_Skszumiflg saikokuTuutiZumiflg = C_Skszumiflg.MISAKUSEI;
        String  minyuttMsg1 = "";
        String  minyuttMsg2 = "";
        String  minyuttMsg3 = "";
        String  minyuttMsg4 = "";
        String  minyuttMsg5 = "";
        String  minyuttMsg6 = "";
        String  minyuttMsg7 = "";
        String  minyuttMsg8 = "";
        String  minyuttMsg9 = "";
        String  minyuttMsg10 = "";
        String  minyuttMsg11 = "";
        String  minyuttMsg12 = "";
        String hrkHouhou = "";
        String Saikokutukiyykkn1 = "";
        String Saikokutukiyykkn2 = "";
        String nextHurikaeNaiyou1 = "";
        String nextHurikaeNaiyou2 = "";
        String nextHurikaeNaiyou3 = "";
        String minyuttAddMsg1 = "";
        String minyuttAddMsg2 = "";
        String minyuttAddMsg3 = "";
        String minyuttAddMsg4 = "";
        String minyuttAddMsg5 = "";
        String minyuttAddMsg6 = "";
        String minyuttAddMsg7 = "";
        String minyuttAddMsg8 = "";
        String minyuttAddMsg9 = "";
        String minyuttAddMsg10 = "";
        String minyuttAddMsg11 = "";
        String minyuttAddMsg12 = "";
        String minyuttAddMsg13 = "";
        String minyuttAddMsg14 = "";
        String minyuttAddMsg15 = "";
        String minyuttAddMsg16 = "";
        String minyuttAddMsg17 = "";
        String minyuttAddMsg18 = "";
        String minyuttAddMsg19 = "";
        String minyuttAddMsg20 = "";
        String minyuttAddMsg21 = "";
        String minyuttAddMsg22 = "";
        String minyuttAddMsg23 = "";
        String minyuttAddMsg24 = "";
        String minyuttAddMsg25 = "";
        String minyuttAddMsg26 = "";
        String minyuttAddMsg27 = "";

        IT_KykSya kykSya = pKykKihon.getKykSya();

        IT_HhknSya hhknSya = pKykKihon.getHhknSya();

        BzGetSosikiMadogutiInfo bzGetSosikiMadogutiInfo = SWAKInjector.getInstance(BzGetSosikiMadogutiInfo.class);

        BzGetSosikiMadogutiInfoKekkaBean bzGetSosikiMadogutiInfoKekkaBean =
            bzGetSosikiMadogutiInfo.exec(YuyuBizConfig.getInstance().getCallcentersosikicd());

        String dispYykknMnryYmd = FixedDateFormatter.formatYMDZenkakuSeirekiKanji(
            pEditCreditMinyuuTuutiParam.getYykknMnryYmd());

        String dispJikaiUrskbi = FixedDateFormatter.formatYMDZenkakuSeirekiKanji(
            pEditCreditMinyuuTuutiParam.getJikaiUrskbi());

        String dispJkiPJytYm = FixedDateFormatter.formatYMZenkakuSeirekiKanji(
            pEditCreditMinyuuTuutiParam.getJkiPJytYm().getFirstDay());

        String dispJkiPJytY = FixedDateFormatter.formatYZenkakuSeirekiKanji(
            pEditCreditMinyuuTuutiParam.getJkiPJytYm().getFirstDay());

        String dispJkiPJytM = FixedDateFormatter.formatMZenkakuKanji(
            pEditCreditMinyuuTuutiParam.getJkiPJytYm().getFirstDay());

        String dispAnnaiGetusuu = Strings.padStart(ConvertUtil.toZenNumeric(
            String.valueOf(pEditCreditMinyuuTuutiParam.getAnnaiGetusuu())), 2, '　');

        String dispAnnaiKingaku = Strings.padStart(ConvertUtil.toZenAll(
            BizUtil.comma(pEditCreditMinyuuTuutiParam.getAnnaiKingaku().toAdsoluteString()), 0, 0), 11, '　');

        boolean syouMetuYokoFlg = false;

        BizDateYM yykknMnryYm = null;
        if (pEditCreditMinyuuTuutiParam.getYykknMnryYmd().getDay() < 15) {

            yykknMnryYm = pEditCreditMinyuuTuutiParam.getYykknMnryYmd().getBizDateYM().getPreviousMonth();

        }
        else {

            yykknMnryYm = pEditCreditMinyuuTuutiParam.getYykknMnryYmd().getBizDateYM();
        }

        BizDateYM ryousyuuYm = pEditCreditMinyuuTuutiParam.getRyousyuuYm().getNextMonth();

        if (BizDateUtil.compareYm(yykknMnryYm, ryousyuuYm) == BizDateUtil.COMPARE_LESSER) {

            yykknMnryYm = ryousyuuYm;
        }

        if (BizDateUtil.compareYm(yykknMnryYm, ryousyuuYm) == BizDateUtil.COMPARE_EQUAL) {

            syouMetuYokoFlg = true;
        }
        else {

            syouMetuYokoFlg = false;
        }

        if (!syouMetuYokoFlg) {

            tuutiNm = KBTUUTINM1;

            saikokuTuutiZumiflg = C_Skszumiflg.MISAKUSEI;
        }
        else {

            tuutiNm = KBTUUTINM2;

            saikokuTuutiZumiflg = C_Skszumiflg.SAKUSEIZUMI;
        }

        if (C_UmuKbn.NONE.eq(pEditCreditMinyuuTuutiParam.getDattaiUktkUmu())) {

            if (C_Yuukoukakkekka.YUUKOUKAK_OK.eq(pEditCreditMinyuuTuutiParam.getYuukoukakkekka()) &&
                C_CreditUriageNgJiyuuKbn.GENDOGAKUTYOUKA.eq(pEditCreditMinyuuTuutiParam.getCreditUriageNgJiyuuKbn())) {

                minyuttMsg1 = KBCREDITOSIRASEMSG_COMMON_1;
                minyuttMsg2 = KBCREDITOSIRASEMSG_COMMON_2 + KBCREDITOSIRASEMSG_GNDGK_2;
                minyuttMsg3 = KBCREDITOSIRASEMSG1_GNDGK3_1 + dispJkiPJytYm + KBCREDITOSIRASEMSG1_GNDGK3_2;
                minyuttMsg4 = KBCREDITOSIRASEMSG1_GNDGK_4;
                minyuttMsg5 = KBCREDITOSIRASEMSG1_GNDGK5_1 + dispJikaiUrskbi + KBCREDITOSIRASEMSG1_GNDGK5_2;
                minyuttMsg6 = KBCREDITOSIRASEMSG1_GNDGK_6;
                minyuttMsg7 = KBCREDITOSIRASEMSG1_GNDGK_7;
                minyuttMsg8 = KBCREDITOSIRASEMSG1_GNDGK_8_YUUYO;
                minyuttMsg9 = KBCREDITOSIRASEMSG1_GNDGK_9_YUUYO;
                minyuttMsg10 = KBCREDITOSIRASEMSG_COMMON_3;
                minyuttMsg11 = KBCREDITOSIRASEMSG_COMMON_4;
                minyuttMsg12 = KB_BLANK;
            }
        }
        else if (C_UmuKbn.ARI.eq(pEditCreditMinyuuTuutiParam.getDattaiUktkUmu())) {

            if (C_Yuukoukakkekka.YUUKOUKAK_OK.eq(pEditCreditMinyuuTuutiParam.getYuukoukakkekka()) &&
                C_CreditUriageNgJiyuuKbn.YUUKOUKIGENERROR.eq(pEditCreditMinyuuTuutiParam.getCreditUriageNgJiyuuKbn())) {

                minyuttMsg1 = KBCREDITOSIRASEMSG_COMMON_1;
                minyuttMsg2 = KBCREDITOSIRASEMSG_COMMON_2 + KBCREDITOSIRASEMSG_DATTAITYU_2;
                minyuttMsg3 = KBCREDITOSIRASEMSG_DATTAITYU_3_1 + dispJkiPJytYm + KBCREDITOSIRASEMSG_DATTAITYU_3_2;
                minyuttMsg4 = KBCREDITOSIRASEMSG_DATTAITYU_4_1;
                minyuttMsg5 = KBCREDITOSIRASEMSG_DATTAITYU_5_YUUYO;
                minyuttMsg6 = KBCREDITOSIRASEMSG_DATTAITYU_6_YUUYO;
                minyuttMsg7 = KBCREDITOSIRASEMSG_DATTAITYU_7_YUUYO;
                minyuttMsg8 = KBCREDITOSIRASEMSG_DATTAITYU_8_YUUYO;
                minyuttMsg9 = KBCREDITOSIRASEMSG_COMMON_3;
                minyuttMsg10 = KBCREDITOSIRASEMSG_COMMON_4;
                minyuttMsg11 = KB_BLANK;
                minyuttMsg12 = KB_BLANK;
            }
            else if (C_Yuukoukakkekka.YUUKOUKAK_NG.eq(pEditCreditMinyuuTuutiParam.getYuukoukakkekka()) &&
                C_DattairiyuuKbn.HRHENKIBOU.eq(pEditCreditMinyuuTuutiParam.getDattaiRiyuuKbn()) &&
                C_Dattaikeiro.CREDIT.eq(pEditCreditMinyuuTuutiParam.getDattaikeiro())) {

                minyuttMsg1 = KBCREDITOSIRASEMSG_COMMON_1;
                minyuttMsg2 = KBCREDITOSIRASEMSG_COMMON_2 + KBCREDITOSIRASEMSG2_YUUKSNG_2;
                minyuttMsg3 = KBCREDITOSIRASEMSG2_YUUKSNG_3;
                minyuttMsg4 = KBCREDITOSIRASEMSG2_YUUKSNG_4 + dispJkiPJytY;
                minyuttMsg5 = dispJkiPJytM + KBCREDITOSIRASEMSG2_YUUKSNG_5;
                minyuttMsg6 = KBCREDITOSIRASEMSG2_YUUKSNG_6_YUUYO;
                minyuttMsg7 = KBCREDITOSIRASEMSG2_YUUKSNG_7_YUUYO;
                minyuttMsg8 = KBCREDITOSIRASEMSG2_YUUKSNG_8_YUUYO;
                minyuttMsg9 = KBCREDITOSIRASEMSG2_YUUKSNG_9_YUUYO;
                minyuttMsg10 = KBCREDITOSIRASEMSG2_YUUKSNG_10_YUUYO;
                minyuttMsg11 = KBCREDITOSIRASEMSG_COMMON_3;
                minyuttMsg12 = KBCREDITOSIRASEMSG_COMMON_4;
            }
            else if (C_Dattaikeiro.ONLINE.eq(pEditCreditMinyuuTuutiParam.getDattaikeiro())) {

                if (C_DattairiyuuKbn.HRHENKIBOU.eq(pEditCreditMinyuuTuutiParam.getDattaiRiyuuKbn())) {

                    minyuttMsg1 = KBCREDITOSIRASEMSG_COMMON_1;
                    minyuttMsg2 = KBCREDITOSIRASEMSG_COMMON_2 + KBCREDITOSIRASEMSG_DATTAITYU_2;
                    minyuttMsg3 = KBCREDITOSIRASEMSG_DATTAITYU_3_1 + dispJkiPJytYm + KBCREDITOSIRASEMSG_DATTAITYU_3_2;
                    minyuttMsg4 = KBCREDITOSIRASEMSG_DATTAITYU_4_1 + KBCREDITOSIRASEMSG_DATTAITYU_4_HRH
                        + KBCREDITOSIRASEMSG_DATTAITYU_4_2;
                    minyuttMsg5 = KBCREDITOSIRASEMSG_DATTAITYU_5_YUUYO;
                    minyuttMsg6 = KBCREDITOSIRASEMSG_DATTAITYU_6_YUUYO;
                    minyuttMsg7 = KBCREDITOSIRASEMSG_DATTAITYU_7_YUUYO;
                    minyuttMsg8 = KBCREDITOSIRASEMSG_DATTAITYU_8_YUUYO;
                    minyuttMsg9 = KBCREDITOSIRASEMSG_COMMON_3;
                    minyuttMsg10 = KBCREDITOSIRASEMSG_COMMON_4;
                    minyuttMsg11 = KB_BLANK;
                    minyuttMsg12 = KB_BLANK;
                }

                else if (C_DattairiyuuKbn.KAIYAKUKIBOU.eq(pEditCreditMinyuuTuutiParam.getDattaiRiyuuKbn())) {

                    minyuttMsg1 = KBCREDITOSIRASEMSG_COMMON_1;
                    minyuttMsg2 = KBCREDITOSIRASEMSG_COMMON_2 + KBCREDITOSIRASEMSG_DATTAITYU_2;
                    minyuttMsg3 = KBCREDITOSIRASEMSG_DATTAITYU_3_1 + dispJkiPJytYm + KBCREDITOSIRASEMSG_DATTAITYU_3_2;
                    minyuttMsg4 = KBCREDITOSIRASEMSG_DATTAITYU_4_1 + KBCREDITOSIRASEMSG_DATTAITYU_4_KAIYK
                        + KBCREDITOSIRASEMSG_DATTAITYU_4_2;
                    minyuttMsg5 = KBCREDITOSIRASEMSG_DATTAITYU_5_YUUYO;
                    minyuttMsg6 = KBCREDITOSIRASEMSG_DATTAITYU_6_YUUYO;
                    minyuttMsg7 = KBCREDITOSIRASEMSG_DATTAITYU_7_YUUYO;
                    minyuttMsg8 = KBCREDITOSIRASEMSG_DATTAITYU_8_YUUYO;
                    minyuttMsg9 = KBCREDITOSIRASEMSG_COMMON_3;
                    minyuttMsg10 = KBCREDITOSIRASEMSG_COMMON_4;
                    minyuttMsg11 = KB_BLANK;
                    minyuttMsg12 = KB_BLANK;
                }

                else if (C_DattairiyuuKbn.KEIYAKUHENKOUARI.eq(pEditCreditMinyuuTuutiParam.getDattaiRiyuuKbn())) {

                    minyuttMsg1 = KBCREDITOSIRASEMSG_COMMON_1;
                    minyuttMsg2 = KBCREDITOSIRASEMSG_COMMON_2 + KBCREDITOSIRASEMSG_DATTAITYU_2;
                    minyuttMsg3 = KBCREDITOSIRASEMSG_DATTAITYU_3_1 + dispJkiPJytYm + KBCREDITOSIRASEMSG_DATTAITYU_3_2;
                    minyuttMsg4 = KBCREDITOSIRASEMSG_DATTAITYU_4_1 + KBCREDITOSIRASEMSG_DATTAITYU_4_KH
                        + KBCREDITOSIRASEMSG_DATTAITYU_4_2;
                    minyuttMsg5 = KBCREDITOSIRASEMSG_DATTAITYU_5_YUUYO;
                    minyuttMsg6 = KBCREDITOSIRASEMSG_DATTAITYU_6_YUUYO;
                    minyuttMsg7 = KBCREDITOSIRASEMSG_DATTAITYU_7_YUUYO;
                    minyuttMsg8 = KBCREDITOSIRASEMSG_DATTAITYU_8_YUUYO;
                    minyuttMsg9 = KBCREDITOSIRASEMSG_COMMON_3;
                    minyuttMsg10 = KBCREDITOSIRASEMSG_COMMON_4;
                    minyuttMsg11 = KB_BLANK;
                    minyuttMsg12 = KB_BLANK;
                }

                else if (C_DattairiyuuKbn.OTHER.eq(pEditCreditMinyuuTuutiParam.getDattaiRiyuuKbn())) {

                    minyuttMsg1 = KBCREDITOSIRASEMSG_COMMON_1;
                    minyuttMsg2 = KBCREDITOSIRASEMSG_COMMON_2 + KBCREDITOSIRASEMSG_DATTAITYU_2;
                    minyuttMsg3 = KBCREDITOSIRASEMSG_DATTAITYU_3_1 + dispJkiPJytYm + KBCREDITOSIRASEMSG_DATTAITYU_3_2;
                    minyuttMsg4 = KBCREDITOSIRASEMSG_DATTAITYU_4_1;
                    minyuttMsg5 = KBCREDITOSIRASEMSG_DATTAITYU_5_YUUYO;
                    minyuttMsg6 = KBCREDITOSIRASEMSG_DATTAITYU_6_YUUYO;
                    minyuttMsg7 = KBCREDITOSIRASEMSG_DATTAITYU_7_YUUYO;
                    minyuttMsg8 = KBCREDITOSIRASEMSG_DATTAITYU_8_YUUYO;
                    minyuttMsg9 = KBCREDITOSIRASEMSG_COMMON_3;
                    minyuttMsg10 = KBCREDITOSIRASEMSG_COMMON_4;
                    minyuttMsg11 = KB_BLANK;
                    minyuttMsg12 = KB_BLANK;
                }
            }
        }

        hrkHouhou = pKykKihon.getHrkkaisuu().getContent();

        if (C_UmuKbn.NONE.eq(pEditCreditMinyuuTuutiParam.getDattaiUktkUmu())) {

            if (C_Yuukoukakkekka.YUUKOUKAK_OK.eq(pEditCreditMinyuuTuutiParam.getYuukoukakkekka()) &&
                C_CreditUriageNgJiyuuKbn.GENDOGAKUTYOUKA.eq(pEditCreditMinyuuTuutiParam.getCreditUriageNgJiyuuKbn())) {

                nextHurikaeNaiyou1 = KBCREDITNEXTHURIKAENAIYOU_GNDGK_1;
                nextHurikaeNaiyou2 = KBNEXTHURIKAEMAIYOU1_2_1 + dispAnnaiKingaku + KBNEXTHURIKAEMAIYOU1_2_2 + dispJkiPJytYm
                    + KBNEXTHURIKAEMAIYOU1_2_3 + dispAnnaiGetusuu + KBNEXTHURIKAEMAIYOU1_2_4;
                nextHurikaeNaiyou3 = KBNEXTHURIKAEMAIYOU1_3;
            }
        }
        else if (C_UmuKbn.ARI.eq(pEditCreditMinyuuTuutiParam.getDattaiUktkUmu())) {

            nextHurikaeNaiyou1 = KBNEXTHURIKAEMAIYOU1_1;
            nextHurikaeNaiyou2 = KBNEXTHURIKAEMAIYOU1_2_1 + dispAnnaiKingaku + KBNEXTHURIKAEMAIYOU1_2_2 + dispJkiPJytYm
                + KBNEXTHURIKAEMAIYOU1_2_3 + dispAnnaiGetusuu + KBNEXTHURIKAEMAIYOU1_2_4;
            nextHurikaeNaiyou3 = KBNEXTHURIKAEMAIYOU1_3;
        }

        Saikokutukiyykkn1 = dispJkiPJytM + KBSAIKOKUKIYYKKN1;
        Saikokutukiyykkn2 = KBSAIKOKUKIYYKKN2 + dispYykknMnryYmd;

        if (!syouMetuYokoFlg) {

            if (C_UmuKbn.NONE.eq(pEditCreditMinyuuTuutiParam.getDattaiUktkUmu())) {

                if (C_Yuukoukakkekka.YUUKOUKAK_OK.eq(pEditCreditMinyuuTuutiParam.getYuukoukakkekka()) &&
                    C_CreditUriageNgJiyuuKbn.GENDOGAKUTYOUKA.eq(
                        pEditCreditMinyuuTuutiParam.getCreditUriageNgJiyuuKbn())) {

                    minyuttAddMsg1 = KB_BLANK;
                    minyuttAddMsg2 = KBCREDITADDMSG_MINYU_1;
                    minyuttAddMsg3 = KBCREDITADDMSG_MINYU_2;
                    minyuttAddMsg4 = KBCREDITADDMSG_MINYU_3;
                    minyuttAddMsg5 = KB_BLANK;
                    minyuttAddMsg6 = KBCREDITADDMSG_COMMON_1;
                    minyuttAddMsg7 = KB_BLANK;
                    minyuttAddMsg8 = KBCREDITADDMSG_COMMON_2;
                    minyuttAddMsg9 = KBCREDITADDMSG_COMMON_3;
                    minyuttAddMsg10 = KB_BLANK;
                    minyuttAddMsg11 = KBCREDITADDMSG1_GNDGK1;
                    minyuttAddMsg12 = KBCREDITADDMSG1_GNDGK2;
                    minyuttAddMsg13 = KBCREDITADDMSG1_GNDGK3;
                    minyuttAddMsg14 = KB_BLANK;
                    minyuttAddMsg15 = KBCREDITADDMSG1_GNDGK_YUUYO_1;
                    minyuttAddMsg16 = KBCREDITADDMSG1_GNDGK_YUUYO_2;
                    minyuttAddMsg17 = KB_BLANK;
                    minyuttAddMsg18 = KBCREDITADDMSG_COMMON_12;
                    minyuttAddMsg19 = KBCREDITADDMSG_COMMON_13;
                    minyuttAddMsg20 = KBCREDITADDMSG_COMMON_14;
                    minyuttAddMsg21 = KB_BLANK;
                    minyuttAddMsg22 = KB_BLANK;
                    minyuttAddMsg23 = KB_BLANK;
                    minyuttAddMsg24 = KB_BLANK;
                    minyuttAddMsg25 = KB_BLANK;
                    minyuttAddMsg26 = KB_BLANK;
                    minyuttAddMsg27 = KB_BLANK;
                }
            }
            else if (C_UmuKbn.ARI.eq(pEditCreditMinyuuTuutiParam.getDattaiUktkUmu())) {

                if (C_Yuukoukakkekka.YUUKOUKAK_OK.eq(pEditCreditMinyuuTuutiParam.getYuukoukakkekka())) {

                    if (C_CreditUriageNgJiyuuKbn.YUUKOUKIGENERROR.eq(
                        pEditCreditMinyuuTuutiParam.getCreditUriageNgJiyuuKbn())) {

                        minyuttAddMsg1 = KB_BLANK;
                        minyuttAddMsg2 = KBCREDITADDMSG_MINYU_1;
                        minyuttAddMsg3 = KBCREDITADDMSG_MINYU_2;
                        minyuttAddMsg4 = KBCREDITADDMSG_MINYU_3;
                        minyuttAddMsg5 = KB_BLANK;
                        minyuttAddMsg6 = KBCREDITADDMSG_COMMON_1;
                        minyuttAddMsg7 = KB_BLANK;
                        minyuttAddMsg8 = KBCREDITADDMSG_COMMON_2;
                        minyuttAddMsg9 = KBCREDITADDMSG_COMMON_3;
                        minyuttAddMsg10 = KB_BLANK;
                        minyuttAddMsg11 = KBCREDITADDMSG2_YKKIGENKIRE_1;
                        minyuttAddMsg12 = KBCREDITADDMSG2_YKKIGENKIRE_2;
                        minyuttAddMsg13 = KBCREDITADDMSG2_YKKIGENKIRE_3;
                        minyuttAddMsg14 = KBCREDITADDMSG2_YKKIGENKIRE_4;
                        minyuttAddMsg15 = KBCREDITADDMSG2_YKKIGENKIRE_5;
                        minyuttAddMsg16 = KBCREDITADDMSG2_YKKIGENKIRE_6;
                        minyuttAddMsg17 = KBCREDITADDMSG2_YKKIGENKIRE_7;
                        minyuttAddMsg18 = KBCREDITADDMSG2_YKKIGENKIRE_8_YUUYO;
                        minyuttAddMsg19 = KBCREDITADDMSG2_YKKIGENKIRE_9;
                        minyuttAddMsg20 = KBCREDITADDMSG2_YKKIGENKIRE_10;
                        minyuttAddMsg21 = KBCREDITADDMSG2_YKKIGENKIRE_11;
                        minyuttAddMsg22 = KB_BLANK;
                        minyuttAddMsg23 = KBCREDITADDMSG_COMMON_12;
                        minyuttAddMsg24 = KBCREDITADDMSG_COMMON_13;
                        minyuttAddMsg25 = KBCREDITADDMSG_COMMON_14;
                        minyuttAddMsg26 = KB_BLANK;
                        minyuttAddMsg27 = KB_BLANK;
                    }
                    else if (C_Dattaikeiro.ONLINE.eq(pEditCreditMinyuuTuutiParam.getDattaikeiro())) {

                        if (C_DattairiyuuKbn.HRHENKIBOU.eq(pEditCreditMinyuuTuutiParam.getDattaiRiyuuKbn())) {

                            minyuttAddMsg1 = KB_BLANK;
                            minyuttAddMsg2 = KBCREDITADDMSG_MINYU_1;
                            minyuttAddMsg3 = KBCREDITADDMSG_MINYU_2;
                            minyuttAddMsg4 = KBCREDITADDMSG_MINYU_3;
                            minyuttAddMsg5 = KB_BLANK;
                            minyuttAddMsg6 = KBCREDITADDMSG_COMMON_1;
                            minyuttAddMsg7 = KB_BLANK;
                            minyuttAddMsg8 = KBCREDITADDMSG_COMMON_2;
                            minyuttAddMsg9 = KBCREDITADDMSG_COMMON_3;
                            minyuttAddMsg10 = KB_BLANK;
                            minyuttAddMsg11 = KBCREDITADDMSG3_DATTAITYU_1_HRH;
                            minyuttAddMsg12 = KBCREDITADDMSG3_DATTAITYU_2_HRH;
                            minyuttAddMsg13 = KBCREDITADDMSG3_DATTAITYU_3_HRH;
                            minyuttAddMsg14 = KBCREDITADDMSG3_DATTAITYU_4_HRH;
                            minyuttAddMsg15 = KB_BLANK;
                            minyuttAddMsg16 = KBCREDITADDMSG_COMMON_12;
                            minyuttAddMsg17 = KBCREDITADDMSG_COMMON_13;
                            minyuttAddMsg18 = KBCREDITADDMSG_COMMON_14;
                            minyuttAddMsg19 = KB_BLANK;
                            minyuttAddMsg20 = KB_BLANK;
                            minyuttAddMsg21 = KB_BLANK;
                            minyuttAddMsg22 = KB_BLANK;
                            minyuttAddMsg23 = KB_BLANK;
                            minyuttAddMsg24 = KB_BLANK;
                            minyuttAddMsg25 = KB_BLANK;
                            minyuttAddMsg26 = KB_BLANK;
                            minyuttAddMsg27 = KB_BLANK;
                        }
                        else if (C_DattairiyuuKbn.KAIYAKUKIBOU.eq(pEditCreditMinyuuTuutiParam.getDattaiRiyuuKbn())) {

                            minyuttAddMsg1 = KB_BLANK;
                            minyuttAddMsg2 = KBCREDITADDMSG_MINYU_1;
                            minyuttAddMsg3 = KBCREDITADDMSG_MINYU_2;
                            minyuttAddMsg4 = KBCREDITADDMSG_MINYU_3;
                            minyuttAddMsg5 = KB_BLANK;
                            minyuttAddMsg6 = KBCREDITADDMSG_COMMON_1;
                            minyuttAddMsg7 = KB_BLANK;
                            minyuttAddMsg8 = KBCREDITADDMSG_COMMON_2;
                            minyuttAddMsg9 = KBCREDITADDMSG_COMMON_3;
                            minyuttAddMsg10 = KB_BLANK;
                            minyuttAddMsg11 = KBCREDITADDMSG5_DATTAITYU_1_KAIYK;
                            minyuttAddMsg12 = KBCREDITADDMSG5_DATTAITYU_2_KAIYK;
                            minyuttAddMsg13 = KBCREDITADDMSG5_DATTAITYU_3_KAIYK;
                            minyuttAddMsg14 = KB_BLANK;
                            minyuttAddMsg15 = KBCREDITADDMSG_COMMON_12;
                            minyuttAddMsg16 = KBCREDITADDMSG_COMMON_13;
                            minyuttAddMsg17 = KBCREDITADDMSG_COMMON_14;
                            minyuttAddMsg18 = KB_BLANK;
                            minyuttAddMsg19 = KB_BLANK;
                            minyuttAddMsg20 = KB_BLANK;
                            minyuttAddMsg21 = KB_BLANK;
                            minyuttAddMsg22 = KB_BLANK;
                            minyuttAddMsg23 = KB_BLANK;
                            minyuttAddMsg24 = KB_BLANK;
                            minyuttAddMsg25 = KB_BLANK;
                            minyuttAddMsg26 = KB_BLANK;
                            minyuttAddMsg27 = KB_BLANK;
                        }
                        else if (C_DattairiyuuKbn.KEIYAKUHENKOUARI.eq(pEditCreditMinyuuTuutiParam.getDattaiRiyuuKbn())) {

                            minyuttAddMsg1 = KB_BLANK;
                            minyuttAddMsg2 = KBCREDITADDMSG_MINYU_1;
                            minyuttAddMsg3 = KBCREDITADDMSG_MINYU_2;
                            minyuttAddMsg4 = KBCREDITADDMSG_MINYU_3;
                            minyuttAddMsg5 = KB_BLANK;
                            minyuttAddMsg6 = KBCREDITADDMSG_COMMON_1;
                            minyuttAddMsg7 = KB_BLANK;
                            minyuttAddMsg8 = KBCREDITADDMSG_COMMON_2;
                            minyuttAddMsg9 = KBCREDITADDMSG_COMMON_3;
                            minyuttAddMsg10 = KB_BLANK;
                            minyuttAddMsg11 = KBCREDITADDMSG4_DATTAITYU_1_KH;
                            minyuttAddMsg12 = KBCREDITADDMSG4_DATTAITYU_2_KH;
                            minyuttAddMsg13 = KBCREDITADDMSG4_DATTAITYU_3_KH;
                            minyuttAddMsg14 = KBCREDITADDMSG4_DATTAITYU_4_KH;
                            minyuttAddMsg15 = KB_BLANK;
                            minyuttAddMsg16 = KBCREDITADDMSG_COMMON_12;
                            minyuttAddMsg17 = KBCREDITADDMSG_COMMON_13;
                            minyuttAddMsg18 = KBCREDITADDMSG_COMMON_14;
                            minyuttAddMsg19 = KB_BLANK;
                            minyuttAddMsg20 = KB_BLANK;
                            minyuttAddMsg21 = KB_BLANK;
                            minyuttAddMsg22 = KB_BLANK;
                            minyuttAddMsg23 = KB_BLANK;
                            minyuttAddMsg24 = KB_BLANK;
                            minyuttAddMsg25 = KB_BLANK;
                            minyuttAddMsg26 = KB_BLANK;
                            minyuttAddMsg27 = KB_BLANK;
                        }
                        else if (C_DattairiyuuKbn.OTHER.eq(pEditCreditMinyuuTuutiParam.getDattaiRiyuuKbn())) {

                            minyuttAddMsg1 = KB_BLANK;
                            minyuttAddMsg2 = KBCREDITADDMSG_MINYU_1;
                            minyuttAddMsg3 = KBCREDITADDMSG_MINYU_2;
                            minyuttAddMsg4 = KBCREDITADDMSG_MINYU_3;
                            minyuttAddMsg5 = KB_BLANK;
                            minyuttAddMsg6 = KBCREDITADDMSG_COMMON_1;
                            minyuttAddMsg7 = KB_BLANK;
                            minyuttAddMsg8 = KBCREDITADDMSG_COMMON_2;
                            minyuttAddMsg9 = KBCREDITADDMSG_COMMON_3;
                            minyuttAddMsg10 = KB_BLANK;
                            minyuttAddMsg11 = KBCREDITADDMSG6_DATTAITYU_1_SONOTA;
                            minyuttAddMsg12 = KBCREDITADDMSG6_DATTAITYU_2_SONOTA;
                            minyuttAddMsg13 = KB_BLANK;
                            minyuttAddMsg14 = KBCREDITADDMSG_COMMON_12;
                            minyuttAddMsg15 = KBCREDITADDMSG_COMMON_13;
                            minyuttAddMsg16 = KBCREDITADDMSG_COMMON_14;
                            minyuttAddMsg17 = KB_BLANK;
                            minyuttAddMsg18 = KB_BLANK;
                            minyuttAddMsg19 = KB_BLANK;
                            minyuttAddMsg20 = KB_BLANK;
                            minyuttAddMsg21 = KB_BLANK;
                            minyuttAddMsg22 = KB_BLANK;
                            minyuttAddMsg23 = KB_BLANK;
                            minyuttAddMsg24 = KB_BLANK;
                            minyuttAddMsg25 = KB_BLANK;
                            minyuttAddMsg26 = KB_BLANK;
                            minyuttAddMsg27 = KB_BLANK;
                        }
                    }
                }
                else if (C_Yuukoukakkekka.YUUKOUKAK_NG.eq(pEditCreditMinyuuTuutiParam.getYuukoukakkekka())) {

                    if (C_Dattaikeiro.CREDIT.eq(pEditCreditMinyuuTuutiParam.getDattaikeiro())) {

                        minyuttAddMsg1 = KB_BLANK;
                        minyuttAddMsg2 = KBCREDITADDMSG_MINYU_1;
                        minyuttAddMsg3 = KBCREDITADDMSG_MINYU_2;
                        minyuttAddMsg4 = KBCREDITADDMSG_MINYU_3;
                        minyuttAddMsg5 = KB_BLANK;
                        minyuttAddMsg6 = KBCREDITADDMSG_COMMON_1;
                        minyuttAddMsg7 = KB_BLANK;
                        minyuttAddMsg8 = KBCREDITADDMSG_COMMON_2;
                        minyuttAddMsg9 = KBCREDITADDMSG_COMMON_3;
                        minyuttAddMsg10 = KB_BLANK;
                        minyuttAddMsg11 = KBCREDITADDMSG7_DATTAITYU_1_NGDATTAI;
                        minyuttAddMsg12 = KBCREDITADDMSG7_DATTAITYU_2_NGDATTAI;
                        minyuttAddMsg13 = KB_BLANK;
                        minyuttAddMsg14 = KBCREDITADDMSG_COMMON_12;
                        minyuttAddMsg15 = KBCREDITADDMSG_COMMON_13;
                        minyuttAddMsg16 = KBCREDITADDMSG_COMMON_14;
                        minyuttAddMsg17 = KB_BLANK;
                        minyuttAddMsg18 = KB_BLANK;
                        minyuttAddMsg19 = KB_BLANK;
                        minyuttAddMsg20 = KB_BLANK;
                        minyuttAddMsg21 = KB_BLANK;
                        minyuttAddMsg22 = KB_BLANK;
                        minyuttAddMsg23 = KB_BLANK;
                        minyuttAddMsg24 = KB_BLANK;
                        minyuttAddMsg25 = KB_BLANK;
                        minyuttAddMsg26 = KB_BLANK;
                        minyuttAddMsg27 = KB_BLANK;
                    }
                    else if (C_Dattaikeiro.ONLINE.eq(pEditCreditMinyuuTuutiParam.getDattaikeiro())) {

                        if (C_DattairiyuuKbn.HRHENKIBOU.eq(pEditCreditMinyuuTuutiParam.getDattaiRiyuuKbn())) {

                            minyuttAddMsg1 = KB_BLANK;
                            minyuttAddMsg2 = KBCREDITADDMSG_MINYU_1;
                            minyuttAddMsg3 = KBCREDITADDMSG_MINYU_2;
                            minyuttAddMsg4 = KBCREDITADDMSG_MINYU_3;
                            minyuttAddMsg5 = KB_BLANK;
                            minyuttAddMsg6 = KBCREDITADDMSG_COMMON_1;
                            minyuttAddMsg7 = KB_BLANK;
                            minyuttAddMsg8 = KBCREDITADDMSG_COMMON_2;
                            minyuttAddMsg9 = KBCREDITADDMSG_COMMON_3;
                            minyuttAddMsg10 = KB_BLANK;
                            minyuttAddMsg11 = KBCREDITADDMSG_COMMON_8;
                            minyuttAddMsg12 = KBCREDITADDMSG_COMMON_9;
                            minyuttAddMsg13 = KBCREDITADDMSG_COMMON_10;
                            minyuttAddMsg14 = KBCREDITADDMSG_COMMON_11;
                            minyuttAddMsg15 = KB_BLANK;
                            minyuttAddMsg16 = KBCREDITADDMSG3_DATTAITYU_1_HRH;
                            minyuttAddMsg17 = KBCREDITADDMSG3_DATTAITYU_2_HRH;
                            minyuttAddMsg18 = KBCREDITADDMSG3_DATTAITYU_3_HRH;
                            minyuttAddMsg19 = KBCREDITADDMSG3_DATTAITYU_4_HRH;
                            minyuttAddMsg20 = KB_BLANK;
                            minyuttAddMsg21 = KBCREDITADDMSG_COMMON_12;
                            minyuttAddMsg22 = KBCREDITADDMSG_COMMON_13;
                            minyuttAddMsg23 = KBCREDITADDMSG_COMMON_14;
                            minyuttAddMsg24 = KB_BLANK;
                            minyuttAddMsg25 = KB_BLANK;
                            minyuttAddMsg26 = KB_BLANK;
                            minyuttAddMsg27 = KB_BLANK;
                        }
                        else if (C_DattairiyuuKbn.KAIYAKUKIBOU.eq(pEditCreditMinyuuTuutiParam.getDattaiRiyuuKbn())) {

                            minyuttAddMsg1 = KB_BLANK;
                            minyuttAddMsg2 = KBCREDITADDMSG_MINYU_1;
                            minyuttAddMsg3 = KBCREDITADDMSG_MINYU_2;
                            minyuttAddMsg4 = KBCREDITADDMSG_MINYU_3;
                            minyuttAddMsg5 = KB_BLANK;
                            minyuttAddMsg6 = KBCREDITADDMSG_COMMON_1;
                            minyuttAddMsg7 = KB_BLANK;
                            minyuttAddMsg8 = KBCREDITADDMSG_COMMON_2;
                            minyuttAddMsg9 = KBCREDITADDMSG_COMMON_3;
                            minyuttAddMsg10 = KB_BLANK;
                            minyuttAddMsg11 = KBCREDITADDMSG_COMMON_8;
                            minyuttAddMsg12 = KBCREDITADDMSG_COMMON_9;
                            minyuttAddMsg13 = KBCREDITADDMSG_COMMON_10;
                            minyuttAddMsg14 = KBCREDITADDMSG_COMMON_11;
                            minyuttAddMsg15 = KB_BLANK;
                            minyuttAddMsg16 = KBCREDITADDMSG5_DATTAITYU_1_KAIYK;
                            minyuttAddMsg17 = KBCREDITADDMSG5_DATTAITYU_2_KAIYK;
                            minyuttAddMsg18 = KBCREDITADDMSG5_DATTAITYU_3_KAIYK;
                            minyuttAddMsg19 = KB_BLANK;
                            minyuttAddMsg20 = KBCREDITADDMSG_COMMON_12;
                            minyuttAddMsg21 = KBCREDITADDMSG_COMMON_13;
                            minyuttAddMsg22 = KBCREDITADDMSG_COMMON_14;
                            minyuttAddMsg23 = KB_BLANK;
                            minyuttAddMsg24 = KB_BLANK;
                            minyuttAddMsg25 = KB_BLANK;
                            minyuttAddMsg26 = KB_BLANK;
                            minyuttAddMsg27 = KB_BLANK;
                        }
                        else if (C_DattairiyuuKbn.KEIYAKUHENKOUARI.eq(pEditCreditMinyuuTuutiParam.getDattaiRiyuuKbn())) {

                            minyuttAddMsg1 = KB_BLANK;
                            minyuttAddMsg2 = KBCREDITADDMSG_MINYU_1;
                            minyuttAddMsg3 = KBCREDITADDMSG_MINYU_2;
                            minyuttAddMsg4 = KBCREDITADDMSG_MINYU_3;
                            minyuttAddMsg5 = KB_BLANK;
                            minyuttAddMsg6 = KBCREDITADDMSG_COMMON_1;
                            minyuttAddMsg7 = KB_BLANK;
                            minyuttAddMsg8 = KBCREDITADDMSG_COMMON_2;
                            minyuttAddMsg9 = KBCREDITADDMSG_COMMON_3;
                            minyuttAddMsg10 = KB_BLANK;
                            minyuttAddMsg11 = KBCREDITADDMSG_COMMON_8;
                            minyuttAddMsg12 = KBCREDITADDMSG_COMMON_9;
                            minyuttAddMsg13 = KBCREDITADDMSG_COMMON_10;
                            minyuttAddMsg14 = KBCREDITADDMSG_COMMON_11;
                            minyuttAddMsg15 = KB_BLANK;
                            minyuttAddMsg16 = KBCREDITADDMSG4_DATTAITYU_1_KH;
                            minyuttAddMsg17 = KBCREDITADDMSG4_DATTAITYU_2_KH;
                            minyuttAddMsg18 = KBCREDITADDMSG4_DATTAITYU_3_KH;
                            minyuttAddMsg19 = KBCREDITADDMSG4_DATTAITYU_4_KH;
                            minyuttAddMsg20 = KB_BLANK;
                            minyuttAddMsg21 = KBCREDITADDMSG_COMMON_12;
                            minyuttAddMsg22 = KBCREDITADDMSG_COMMON_13;
                            minyuttAddMsg23 = KBCREDITADDMSG_COMMON_14;
                            minyuttAddMsg24 = KB_BLANK;
                            minyuttAddMsg25 = KB_BLANK;
                            minyuttAddMsg26 = KB_BLANK;
                            minyuttAddMsg27 = KB_BLANK;
                        }
                        else if (C_DattairiyuuKbn.OTHER.eq(pEditCreditMinyuuTuutiParam.getDattaiRiyuuKbn())) {

                            minyuttAddMsg1 = KB_BLANK;
                            minyuttAddMsg2 = KBCREDITADDMSG_MINYU_1;
                            minyuttAddMsg3 = KBCREDITADDMSG_MINYU_2;
                            minyuttAddMsg4 = KBCREDITADDMSG_MINYU_3;
                            minyuttAddMsg5 = KB_BLANK;
                            minyuttAddMsg6 = KBCREDITADDMSG_COMMON_1;
                            minyuttAddMsg7 = KB_BLANK;
                            minyuttAddMsg8 = KBCREDITADDMSG_COMMON_2;
                            minyuttAddMsg9 = KBCREDITADDMSG_COMMON_3;
                            minyuttAddMsg10 = KB_BLANK;
                            minyuttAddMsg11 = KBCREDITADDMSG6_DATTAITYU_3_SONOTA;
                            minyuttAddMsg12 = KBCREDITADDMSG6_DATTAITYU_4_SONOTA;
                            minyuttAddMsg13 = KBCREDITADDMSG6_DATTAITYU_5_SONOTA;
                            minyuttAddMsg14 = KB_BLANK;
                            minyuttAddMsg15 = KBCREDITADDMSG6_DATTAITYU_1_SONOTA;
                            minyuttAddMsg16 = KBCREDITADDMSG6_DATTAITYU_2_SONOTA;
                            minyuttAddMsg17 = KB_BLANK;
                            minyuttAddMsg18 = KBCREDITADDMSG_COMMON_12;
                            minyuttAddMsg19 = KBCREDITADDMSG_COMMON_13;
                            minyuttAddMsg20 = KBCREDITADDMSG_COMMON_14;
                            minyuttAddMsg21 = KB_BLANK;
                            minyuttAddMsg22 = KB_BLANK;
                            minyuttAddMsg23 = KB_BLANK;
                            minyuttAddMsg24 = KB_BLANK;
                            minyuttAddMsg25 = KB_BLANK;
                            minyuttAddMsg26 = KB_BLANK;
                            minyuttAddMsg27 = KB_BLANK;
                        }
                    }
                }
            }
        }
        else {

            if (C_UmuKbn.NONE.eq(pEditCreditMinyuuTuutiParam.getDattaiUktkUmu())) {

                if (C_Yuukoukakkekka.YUUKOUKAK_OK.eq(pEditCreditMinyuuTuutiParam.getYuukoukakkekka()) &&
                    C_CreditUriageNgJiyuuKbn.GENDOGAKUTYOUKA.eq(
                        pEditCreditMinyuuTuutiParam.getCreditUriageNgJiyuuKbn())) {

                    minyuttAddMsg1 = KB_BLANK;
                    minyuttAddMsg2 = KBCREDITADDMSG_MINYU_1;
                    minyuttAddMsg3 = KBCREDITADDMSG_MINYU_2;
                    minyuttAddMsg4 = KBCREDITADDMSG_MINYU_3;
                    minyuttAddMsg5 = KBCREDITADDMSG_COMMON_2;
                    minyuttAddMsg6 = KBCREDITADDMSG_COMMON_3;
                    minyuttAddMsg7 = KBCREDITADDMSG_COMMON_1;
                    minyuttAddMsg8 = KBCREDITADDMSG1_GNDGK1;
                    minyuttAddMsg9 = KBCREDITADDMSG1_GNDGK2;
                    minyuttAddMsg10 = KBCREDITADDMSG1_GNDGK3;
                    minyuttAddMsg11 = KBCREDITADDMSG1_GNDGK_YUUYO_1;
                    minyuttAddMsg12 = KBCREDITADDMSG1_GNDGK_YUUYO_2;
                    minyuttAddMsg13 = KBCREDITADDMSG_COMMON_4;
                    minyuttAddMsg14 = KBCREDITADDMSG_COMMON_5;
                    minyuttAddMsg15 = KBCREDITADDMSG_COMMON_6;
                    minyuttAddMsg16 = KBCREDITADDMSG_COMMON_7;
                    minyuttAddMsg17 = KBCREDITADDMSG_COMMON_12;
                    minyuttAddMsg18 = KBCREDITADDMSG_COMMON_13;
                    minyuttAddMsg19 = KBCREDITADDMSG_COMMON_14;
                    minyuttAddMsg20 = KB_BLANK;
                    minyuttAddMsg21 = KB_BLANK;
                    minyuttAddMsg22 = KB_BLANK;
                    minyuttAddMsg23 = KB_BLANK;
                    minyuttAddMsg24 = KB_BLANK;
                    minyuttAddMsg25 = KB_BLANK;
                    minyuttAddMsg26 = KB_BLANK;
                    minyuttAddMsg27 = KB_BLANK;
                }
            }
            else if (C_UmuKbn.ARI.eq(pEditCreditMinyuuTuutiParam.getDattaiUktkUmu())) {

                if (C_Yuukoukakkekka.YUUKOUKAK_OK.eq(pEditCreditMinyuuTuutiParam.getYuukoukakkekka())) {

                    if (C_CreditUriageNgJiyuuKbn.YUUKOUKIGENERROR.eq(
                        pEditCreditMinyuuTuutiParam.getCreditUriageNgJiyuuKbn())) {

                        minyuttAddMsg1 = KB_BLANK;
                        minyuttAddMsg2 = KBCREDITADDMSG_MINYU_1;
                        minyuttAddMsg3 = KBCREDITADDMSG_MINYU_2;
                        minyuttAddMsg4 = KBCREDITADDMSG_MINYU_3;
                        minyuttAddMsg5 = KBCREDITADDMSG_COMMON_2;
                        minyuttAddMsg6 = KBCREDITADDMSG_COMMON_3;
                        minyuttAddMsg7 = KBCREDITADDMSG_COMMON_1;
                        minyuttAddMsg8 = KBCREDITADDMSG_COMMON_4;
                        minyuttAddMsg9 = KBCREDITADDMSG_COMMON_5;
                        minyuttAddMsg10 = KBCREDITADDMSG_COMMON_6;
                        minyuttAddMsg11 = KBCREDITADDMSG_COMMON_7;
                        minyuttAddMsg12 = KBCREDITADDMSG2_YKKIGENKIRE_1;
                        minyuttAddMsg13 = KBCREDITADDMSG2_YKKIGENKIRE_2;
                        minyuttAddMsg14 = KBCREDITADDMSG2_YKKIGENKIRE_3;
                        minyuttAddMsg15 = KBCREDITADDMSG2_YKKIGENKIRE_4;
                        minyuttAddMsg16 = KBCREDITADDMSG2_YKKIGENKIRE_5;
                        minyuttAddMsg17 = KBCREDITADDMSG2_YKKIGENKIRE_6;
                        minyuttAddMsg18 = KBCREDITADDMSG2_YKKIGENKIRE_7;
                        minyuttAddMsg19 = KBCREDITADDMSG2_YKKIGENKIRE_8_YUUYO;
                        minyuttAddMsg20 = KBCREDITADDMSG2_YKKIGENKIRE_9;
                        minyuttAddMsg21 = KBCREDITADDMSG2_YKKIGENKIRE_10;
                        minyuttAddMsg22 = KBCREDITADDMSG2_YKKIGENKIRE_11;
                        minyuttAddMsg23 = KBCREDITADDMSG_COMMON_12;
                        minyuttAddMsg24 = KBCREDITADDMSG_COMMON_13;
                        minyuttAddMsg25 = KBCREDITADDMSG_COMMON_14;
                        minyuttAddMsg26 = KB_BLANK;
                        minyuttAddMsg27 = KB_BLANK;
                    }
                    else if (C_Dattaikeiro.ONLINE.eq(pEditCreditMinyuuTuutiParam.getDattaikeiro())) {

                        if (C_DattairiyuuKbn.HRHENKIBOU.eq(pEditCreditMinyuuTuutiParam.getDattaiRiyuuKbn())) {

                            minyuttAddMsg1 = KB_BLANK;
                            minyuttAddMsg2 = KBCREDITADDMSG_MINYU_1;
                            minyuttAddMsg3 = KBCREDITADDMSG_MINYU_2;
                            minyuttAddMsg4 = KBCREDITADDMSG_MINYU_3;
                            minyuttAddMsg5 = KBCREDITADDMSG_COMMON_2;
                            minyuttAddMsg6 = KBCREDITADDMSG_COMMON_3;
                            minyuttAddMsg7 = KBCREDITADDMSG_COMMON_1;
                            minyuttAddMsg8 = KBCREDITADDMSG_COMMON_4;
                            minyuttAddMsg9 = KBCREDITADDMSG_COMMON_5;
                            minyuttAddMsg10 = KBCREDITADDMSG_COMMON_6;
                            minyuttAddMsg11 = KBCREDITADDMSG_COMMON_7;
                            minyuttAddMsg12 = KBCREDITADDMSG3_DATTAITYU_1_HRH;
                            minyuttAddMsg13 = KBCREDITADDMSG3_DATTAITYU_2_HRH;
                            minyuttAddMsg14 = KBCREDITADDMSG3_DATTAITYU_3_HRH;
                            minyuttAddMsg15 = KBCREDITADDMSG3_DATTAITYU_4_HRH;
                            minyuttAddMsg16 = KBCREDITADDMSG_COMMON_12;
                            minyuttAddMsg17 = KBCREDITADDMSG_COMMON_13;
                            minyuttAddMsg18 = KBCREDITADDMSG_COMMON_14;
                            minyuttAddMsg19 = KB_BLANK;
                            minyuttAddMsg20 = KB_BLANK;
                            minyuttAddMsg21 = KB_BLANK;
                            minyuttAddMsg22 = KB_BLANK;
                            minyuttAddMsg23 = KB_BLANK;
                            minyuttAddMsg24 = KB_BLANK;
                            minyuttAddMsg25 = KB_BLANK;
                            minyuttAddMsg26 = KB_BLANK;
                            minyuttAddMsg27 = KB_BLANK;
                        }
                        else if (C_DattairiyuuKbn.KAIYAKUKIBOU.eq(pEditCreditMinyuuTuutiParam.getDattaiRiyuuKbn())) {

                            minyuttAddMsg1 = KB_BLANK;
                            minyuttAddMsg2 = KBCREDITADDMSG_MINYU_1;
                            minyuttAddMsg3 = KBCREDITADDMSG_MINYU_2;
                            minyuttAddMsg4 = KBCREDITADDMSG_MINYU_3;
                            minyuttAddMsg5 = KBCREDITADDMSG_COMMON_2;
                            minyuttAddMsg6 = KBCREDITADDMSG_COMMON_3;
                            minyuttAddMsg7 = KBCREDITADDMSG_COMMON_1;
                            minyuttAddMsg8 = KBCREDITADDMSG_COMMON_4;
                            minyuttAddMsg9 = KBCREDITADDMSG_COMMON_5;
                            minyuttAddMsg10 = KBCREDITADDMSG_COMMON_6;
                            minyuttAddMsg11 = KBCREDITADDMSG_COMMON_7;
                            minyuttAddMsg12 = KBCREDITADDMSG5_DATTAITYU_1_KAIYK;
                            minyuttAddMsg13 = KBCREDITADDMSG5_DATTAITYU_2_KAIYK;
                            minyuttAddMsg14 = KBCREDITADDMSG5_DATTAITYU_3_KAIYK;
                            minyuttAddMsg15 = KBCREDITADDMSG_COMMON_12;
                            minyuttAddMsg16 = KBCREDITADDMSG_COMMON_13;
                            minyuttAddMsg17 = KBCREDITADDMSG_COMMON_14;
                            minyuttAddMsg18 = KB_BLANK;
                            minyuttAddMsg19 = KB_BLANK;
                            minyuttAddMsg20 = KB_BLANK;
                            minyuttAddMsg21 = KB_BLANK;
                            minyuttAddMsg22 = KB_BLANK;
                            minyuttAddMsg23 = KB_BLANK;
                            minyuttAddMsg24 = KB_BLANK;
                            minyuttAddMsg25 = KB_BLANK;
                            minyuttAddMsg26 = KB_BLANK;
                            minyuttAddMsg27 = KB_BLANK;
                        }
                        else if (C_DattairiyuuKbn.KEIYAKUHENKOUARI.eq(pEditCreditMinyuuTuutiParam.getDattaiRiyuuKbn())) {

                            minyuttAddMsg1 = KB_BLANK;
                            minyuttAddMsg2 = KBCREDITADDMSG_MINYU_1;
                            minyuttAddMsg3 = KBCREDITADDMSG_MINYU_2;
                            minyuttAddMsg4 = KBCREDITADDMSG_MINYU_3;
                            minyuttAddMsg5 = KBCREDITADDMSG_COMMON_2;
                            minyuttAddMsg6 = KBCREDITADDMSG_COMMON_3;
                            minyuttAddMsg7 = KBCREDITADDMSG_COMMON_1;
                            minyuttAddMsg8 = KBCREDITADDMSG_COMMON_4;
                            minyuttAddMsg9 = KBCREDITADDMSG_COMMON_5;
                            minyuttAddMsg10 = KBCREDITADDMSG_COMMON_6;
                            minyuttAddMsg11 = KBCREDITADDMSG_COMMON_7;
                            minyuttAddMsg12 = KBCREDITADDMSG4_DATTAITYU_1_KH;
                            minyuttAddMsg13 = KBCREDITADDMSG4_DATTAITYU_2_KH;
                            minyuttAddMsg14 = KBCREDITADDMSG4_DATTAITYU_3_KH;
                            minyuttAddMsg15 = KBCREDITADDMSG4_DATTAITYU_4_KH;
                            minyuttAddMsg16 = KBCREDITADDMSG_COMMON_12;
                            minyuttAddMsg17 = KBCREDITADDMSG_COMMON_13;
                            minyuttAddMsg18 = KBCREDITADDMSG_COMMON_14;
                            minyuttAddMsg19 = KB_BLANK;
                            minyuttAddMsg20 = KB_BLANK;
                            minyuttAddMsg21 = KB_BLANK;
                            minyuttAddMsg22 = KB_BLANK;
                            minyuttAddMsg23 = KB_BLANK;
                            minyuttAddMsg24 = KB_BLANK;
                            minyuttAddMsg25 = KB_BLANK;
                            minyuttAddMsg26 = KB_BLANK;
                            minyuttAddMsg27 = KB_BLANK;
                        }
                        else if (C_DattairiyuuKbn.OTHER.eq(pEditCreditMinyuuTuutiParam.getDattaiRiyuuKbn())) {

                            minyuttAddMsg1 = KB_BLANK;
                            minyuttAddMsg2 = KBCREDITADDMSG_MINYU_1;
                            minyuttAddMsg3 = KBCREDITADDMSG_MINYU_2;
                            minyuttAddMsg4 = KBCREDITADDMSG_MINYU_3;
                            minyuttAddMsg5 = KBCREDITADDMSG_COMMON_2;
                            minyuttAddMsg6 = KBCREDITADDMSG_COMMON_3;
                            minyuttAddMsg7 = KBCREDITADDMSG_COMMON_1;
                            minyuttAddMsg8 = KBCREDITADDMSG_COMMON_4;
                            minyuttAddMsg9 = KBCREDITADDMSG_COMMON_5;
                            minyuttAddMsg10 = KBCREDITADDMSG_COMMON_6;
                            minyuttAddMsg11 = KBCREDITADDMSG_COMMON_7;
                            minyuttAddMsg12 = KBCREDITADDMSG6_DATTAITYU_1_SONOTA;
                            minyuttAddMsg13 = KBCREDITADDMSG6_DATTAITYU_2_SONOTA;
                            minyuttAddMsg14 = KBCREDITADDMSG_COMMON_12;
                            minyuttAddMsg15 = KBCREDITADDMSG_COMMON_13;
                            minyuttAddMsg16 = KBCREDITADDMSG_COMMON_14;
                            minyuttAddMsg17 = KB_BLANK;
                            minyuttAddMsg18 = KB_BLANK;
                            minyuttAddMsg19 = KB_BLANK;
                            minyuttAddMsg20 = KB_BLANK;
                            minyuttAddMsg21 = KB_BLANK;
                            minyuttAddMsg22 = KB_BLANK;
                            minyuttAddMsg23 = KB_BLANK;
                            minyuttAddMsg24 = KB_BLANK;
                            minyuttAddMsg25 = KB_BLANK;
                            minyuttAddMsg26 = KB_BLANK;
                            minyuttAddMsg27 = KB_BLANK;
                        }
                    }
                }
                else if (C_Yuukoukakkekka.YUUKOUKAK_NG.eq(pEditCreditMinyuuTuutiParam.getYuukoukakkekka())) {

                    if (C_Dattaikeiro.CREDIT.eq(pEditCreditMinyuuTuutiParam.getDattaikeiro())) {

                        minyuttAddMsg1 = KB_BLANK;
                        minyuttAddMsg2 = KBCREDITADDMSG_MINYU_1;
                        minyuttAddMsg3 = KBCREDITADDMSG_MINYU_2;
                        minyuttAddMsg4 = KBCREDITADDMSG_MINYU_3;
                        minyuttAddMsg5 = KBCREDITADDMSG_COMMON_2;
                        minyuttAddMsg6 = KBCREDITADDMSG_COMMON_3;
                        minyuttAddMsg7 = KBCREDITADDMSG_COMMON_1;
                        minyuttAddMsg8 = KBCREDITADDMSG_COMMON_4;
                        minyuttAddMsg9 = KBCREDITADDMSG_COMMON_5;
                        minyuttAddMsg10 = KBCREDITADDMSG_COMMON_6;
                        minyuttAddMsg11 = KBCREDITADDMSG_COMMON_7;
                        minyuttAddMsg12 = KBCREDITADDMSG7_DATTAITYU_1_NGDATTAI;
                        minyuttAddMsg13 = KBCREDITADDMSG7_DATTAITYU_2_NGDATTAI;
                        minyuttAddMsg14 = KBCREDITADDMSG_COMMON_12;
                        minyuttAddMsg15 = KBCREDITADDMSG_COMMON_13;
                        minyuttAddMsg16 = KBCREDITADDMSG_COMMON_14;
                        minyuttAddMsg17 = KB_BLANK;
                        minyuttAddMsg18 = KB_BLANK;
                        minyuttAddMsg19 = KB_BLANK;
                        minyuttAddMsg20 = KB_BLANK;
                        minyuttAddMsg21 = KB_BLANK;
                        minyuttAddMsg22 = KB_BLANK;
                        minyuttAddMsg23 = KB_BLANK;
                        minyuttAddMsg24 = KB_BLANK;
                        minyuttAddMsg25 = KB_BLANK;
                        minyuttAddMsg26 = KB_BLANK;
                        minyuttAddMsg27 = KB_BLANK;
                    }
                    else if (C_Dattaikeiro.ONLINE.eq(pEditCreditMinyuuTuutiParam.getDattaikeiro())) {

                        if (C_DattairiyuuKbn.HRHENKIBOU.eq(pEditCreditMinyuuTuutiParam.getDattaiRiyuuKbn())) {

                            minyuttAddMsg1 = KB_BLANK;
                            minyuttAddMsg2 = KBCREDITADDMSG_MINYU_1;
                            minyuttAddMsg3 = KBCREDITADDMSG_MINYU_2;
                            minyuttAddMsg4 = KBCREDITADDMSG_MINYU_3;
                            minyuttAddMsg5 = KBCREDITADDMSG_COMMON_2;
                            minyuttAddMsg6 = KBCREDITADDMSG_COMMON_3;
                            minyuttAddMsg7 = KBCREDITADDMSG_COMMON_1;
                            minyuttAddMsg8 = KBCREDITADDMSG_COMMON_4;
                            minyuttAddMsg9 = KBCREDITADDMSG_COMMON_5;
                            minyuttAddMsg10 = KBCREDITADDMSG_COMMON_6;
                            minyuttAddMsg11 = KBCREDITADDMSG_COMMON_7;
                            minyuttAddMsg12 = KBCREDITADDMSG_COMMON_8;
                            minyuttAddMsg13 = KBCREDITADDMSG_COMMON_9;
                            minyuttAddMsg14 = KBCREDITADDMSG_COMMON_10;
                            minyuttAddMsg15 = KBCREDITADDMSG_COMMON_11;
                            minyuttAddMsg16 = KBCREDITADDMSG3_DATTAITYU_1_HRH;
                            minyuttAddMsg17 = KBCREDITADDMSG3_DATTAITYU_2_HRH;
                            minyuttAddMsg18 = KBCREDITADDMSG3_DATTAITYU_3_HRH;
                            minyuttAddMsg19 = KBCREDITADDMSG3_DATTAITYU_4_HRH;
                            minyuttAddMsg20 = KBCREDITADDMSG_COMMON_12;
                            minyuttAddMsg21 = KBCREDITADDMSG_COMMON_13;
                            minyuttAddMsg22 = KBCREDITADDMSG_COMMON_14;
                            minyuttAddMsg23 = KB_BLANK;
                            minyuttAddMsg24 = KB_BLANK;
                            minyuttAddMsg25 = KB_BLANK;
                            minyuttAddMsg26 = KB_BLANK;
                            minyuttAddMsg27 = KB_BLANK;
                        }
                        else if (C_DattairiyuuKbn.KAIYAKUKIBOU.eq(pEditCreditMinyuuTuutiParam.getDattaiRiyuuKbn())) {

                            minyuttAddMsg1 = KB_BLANK;
                            minyuttAddMsg2 = KBCREDITADDMSG_MINYU_1;
                            minyuttAddMsg3 = KBCREDITADDMSG_MINYU_2;
                            minyuttAddMsg4 = KBCREDITADDMSG_MINYU_3;
                            minyuttAddMsg5 = KBCREDITADDMSG_COMMON_2;
                            minyuttAddMsg6 = KBCREDITADDMSG_COMMON_3;
                            minyuttAddMsg7 = KBCREDITADDMSG_COMMON_1;
                            minyuttAddMsg8 = KBCREDITADDMSG_COMMON_4;
                            minyuttAddMsg9 = KBCREDITADDMSG_COMMON_5;
                            minyuttAddMsg10 = KBCREDITADDMSG_COMMON_6;
                            minyuttAddMsg11 = KBCREDITADDMSG_COMMON_7;
                            minyuttAddMsg12 = KBCREDITADDMSG_COMMON_8;
                            minyuttAddMsg13 = KBCREDITADDMSG_COMMON_9;
                            minyuttAddMsg14 = KBCREDITADDMSG_COMMON_10;
                            minyuttAddMsg15 = KBCREDITADDMSG_COMMON_11;
                            minyuttAddMsg16 = KBCREDITADDMSG5_DATTAITYU_1_KAIYK;
                            minyuttAddMsg17 = KBCREDITADDMSG5_DATTAITYU_2_KAIYK;
                            minyuttAddMsg18 = KBCREDITADDMSG5_DATTAITYU_3_KAIYK;
                            minyuttAddMsg19 = KBCREDITADDMSG_COMMON_12;
                            minyuttAddMsg20 = KBCREDITADDMSG_COMMON_13;
                            minyuttAddMsg21 = KBCREDITADDMSG_COMMON_14;
                            minyuttAddMsg22 = KB_BLANK;
                            minyuttAddMsg23 = KB_BLANK;
                            minyuttAddMsg24 = KB_BLANK;
                            minyuttAddMsg25 = KB_BLANK;
                            minyuttAddMsg26 = KB_BLANK;
                            minyuttAddMsg27 = KB_BLANK;
                        }
                        else if (C_DattairiyuuKbn.KEIYAKUHENKOUARI.eq(pEditCreditMinyuuTuutiParam.getDattaiRiyuuKbn())) {

                            minyuttAddMsg1 = KB_BLANK;
                            minyuttAddMsg2 = KBCREDITADDMSG_MINYU_1;
                            minyuttAddMsg3 = KBCREDITADDMSG_MINYU_2;
                            minyuttAddMsg4 = KBCREDITADDMSG_MINYU_3;
                            minyuttAddMsg5 = KBCREDITADDMSG_COMMON_2;
                            minyuttAddMsg6 = KBCREDITADDMSG_COMMON_3;
                            minyuttAddMsg7 = KBCREDITADDMSG_COMMON_1;
                            minyuttAddMsg8 = KBCREDITADDMSG_COMMON_4;
                            minyuttAddMsg9 = KBCREDITADDMSG_COMMON_5;
                            minyuttAddMsg10 = KBCREDITADDMSG_COMMON_6;
                            minyuttAddMsg11 = KBCREDITADDMSG_COMMON_7;
                            minyuttAddMsg12 = KBCREDITADDMSG_COMMON_8;
                            minyuttAddMsg13 = KBCREDITADDMSG_COMMON_9;
                            minyuttAddMsg14 = KBCREDITADDMSG_COMMON_10;
                            minyuttAddMsg15 = KBCREDITADDMSG_COMMON_11;
                            minyuttAddMsg16 = KBCREDITADDMSG4_DATTAITYU_1_KH;
                            minyuttAddMsg17 = KBCREDITADDMSG4_DATTAITYU_2_KH;
                            minyuttAddMsg18 = KBCREDITADDMSG4_DATTAITYU_3_KH;
                            minyuttAddMsg19 = KBCREDITADDMSG4_DATTAITYU_4_KH;
                            minyuttAddMsg20 = KBCREDITADDMSG_COMMON_12;
                            minyuttAddMsg21 = KBCREDITADDMSG_COMMON_13;
                            minyuttAddMsg22 = KBCREDITADDMSG_COMMON_14;
                            minyuttAddMsg23 = KB_BLANK;
                            minyuttAddMsg24 = KB_BLANK;
                            minyuttAddMsg25 = KB_BLANK;
                            minyuttAddMsg26 = KB_BLANK;
                            minyuttAddMsg27 = KB_BLANK;
                        }
                        else if (C_DattairiyuuKbn.OTHER.eq(pEditCreditMinyuuTuutiParam.getDattaiRiyuuKbn())) {

                            minyuttAddMsg1 = KB_BLANK;
                            minyuttAddMsg2 = KBCREDITADDMSG_MINYU_1;
                            minyuttAddMsg3 = KBCREDITADDMSG_MINYU_2;
                            minyuttAddMsg4 = KBCREDITADDMSG_MINYU_3;
                            minyuttAddMsg5 = KBCREDITADDMSG_COMMON_2;
                            minyuttAddMsg6 = KBCREDITADDMSG_COMMON_3;
                            minyuttAddMsg7 = KBCREDITADDMSG_COMMON_1;
                            minyuttAddMsg8 = KBCREDITADDMSG_COMMON_4;
                            minyuttAddMsg9 = KBCREDITADDMSG_COMMON_5;
                            minyuttAddMsg10 = KBCREDITADDMSG_COMMON_6;
                            minyuttAddMsg11 = KBCREDITADDMSG_COMMON_7;
                            minyuttAddMsg12 = KBCREDITADDMSG6_DATTAITYU_3_SONOTA;
                            minyuttAddMsg13 = KBCREDITADDMSG6_DATTAITYU_4_SONOTA;
                            minyuttAddMsg14 = KBCREDITADDMSG6_DATTAITYU_5_SONOTA;
                            minyuttAddMsg15 = KBCREDITADDMSG6_DATTAITYU_1_SONOTA;
                            minyuttAddMsg16 = KBCREDITADDMSG6_DATTAITYU_2_SONOTA;
                            minyuttAddMsg17 = KBCREDITADDMSG_COMMON_12;
                            minyuttAddMsg18 = KBCREDITADDMSG_COMMON_13;
                            minyuttAddMsg19 = KBCREDITADDMSG_COMMON_14;
                            minyuttAddMsg20 = KB_BLANK;
                            minyuttAddMsg21 = KB_BLANK;
                            minyuttAddMsg22 = KB_BLANK;
                            minyuttAddMsg23 = KB_BLANK;
                            minyuttAddMsg24 = KB_BLANK;
                            minyuttAddMsg25 = KB_BLANK;
                            minyuttAddMsg26 = KB_BLANK;
                            minyuttAddMsg27 = KB_BLANK;
                        }
                    }
                }
            }
        }

        IT_KouzahuriMinyuTuuti kouzahuriMinyuTuuti = new IT_KouzahuriMinyuTuuti(pKykKihon.getSyono(), pSyoriymd);

        kouzahuriMinyuTuuti.setSyoruiCd(C_SyoruiCdKbn.AS_CREDITMINYUUTUUTI);
        kouzahuriMinyuTuuti.setHassoukbn(pHassouKbn);
        kouzahuriMinyuTuuti.setShskyno(kykSya.getTsinyno());
        kouzahuriMinyuTuuti.setShsadr1kj(kykSya.getTsinadr1kj());
        kouzahuriMinyuTuuti.setShsadr2kj(kykSya.getTsinadr2kj());
        kouzahuriMinyuTuuti.setShsadr3kj(kykSya.getTsinadr3kj());
        kouzahuriMinyuTuuti.setShsnmkj(kykSya.getKyknmkj());
        kouzahuriMinyuTuuti.setToiawasesosikinmkj(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikinm());
        kouzahuriMinyuTuuti.setToiawaseyno(bzGetSosikiMadogutiInfoKekkaBean.getPostalCd());
        kouzahuriMinyuTuuti.setToiawaseadr1kj(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr1());
        kouzahuriMinyuTuuti.setToiawaseadr2kj(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr2());
        kouzahuriMinyuTuuti.setToiawaseadr3kj(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr3());
        kouzahuriMinyuTuuti.setToiawasetelno(bzGetSosikiMadogutiInfoKekkaBean.getTelno());
        kouzahuriMinyuTuuti.setToiawaseteluktkkanou1(YuyuBizConfig.getInstance().getUketimecallcenter1());
        kouzahuriMinyuTuuti.setToiawaseteluktkkanou2(YuyuBizConfig.getInstance().getUketimecallcenter2());
        kouzahuriMinyuTuuti.setTuutinm30keta(tuutiNm);
        kouzahuriMinyuTuuti.setMinyuttmsg1(minyuttMsg1);
        kouzahuriMinyuTuuti.setMinyuttmsg2(minyuttMsg2);
        kouzahuriMinyuTuuti.setMinyuttmsg3(minyuttMsg3);
        kouzahuriMinyuTuuti.setMinyuttmsg4(minyuttMsg4);
        kouzahuriMinyuTuuti.setMinyuttmsg5(minyuttMsg5);
        kouzahuriMinyuTuuti.setMinyuttmsg6(minyuttMsg6);
        kouzahuriMinyuTuuti.setMinyuttmsg7(minyuttMsg7);
        kouzahuriMinyuTuuti.setMinyuttmsg8(minyuttMsg8);
        kouzahuriMinyuTuuti.setMinyuttmsg9(minyuttMsg9);
        kouzahuriMinyuTuuti.setMinyuttmsg10(minyuttMsg10);
        kouzahuriMinyuTuuti.setMinyuttmsg11(minyuttMsg11);
        kouzahuriMinyuTuuti.setMinyuttmsg12(minyuttMsg12);
        kouzahuriMinyuTuuti.setPannainm(KBPANNAINM);
        kouzahuriMinyuTuuti.setHrkhou12keta(hrkHouhou);
        kouzahuriMinyuTuuti.setHhknnmkj(hhknSya.getHhknnmkj());
        kouzahuriMinyuTuuti.setNexthurikaenaiyou1(nextHurikaeNaiyou1);
        kouzahuriMinyuTuuti.setNexthurikaenaiyou2(nextHurikaeNaiyou2);
        kouzahuriMinyuTuuti.setNexthurikaenaiyou3(nextHurikaeNaiyou3);
        kouzahuriMinyuTuuti.setSaikokutukiyykkn1(Saikokutukiyykkn1);
        kouzahuriMinyuTuuti.setSaikokutukiyykkn2(Saikokutukiyykkn2);
        kouzahuriMinyuTuuti.setHrkmirmsg1(KB_BLANK);
        kouzahuriMinyuTuuti.setHrkmirmsg2(KB_BLANK);
        kouzahuriMinyuTuuti.setHrkmirmsg3(KB_BLANK);
        kouzahuriMinyuTuuti.setZenhurikaenaiyou1(KB_BLANK);
        kouzahuriMinyuTuuti.setZenhurikaenaiyou2(KB_BLANK);
        kouzahuriMinyuTuuti.setZenhurikaenaiyou3(KB_BLANK);
        kouzahuriMinyuTuuti.setZenhurikaenaiyou4(KB_BLANK);
        kouzahuriMinyuTuuti.setHurikaekz37keta1(minyuttAddMsg1);
        kouzahuriMinyuTuuti.setHurikaekz37keta2(minyuttAddMsg2);
        kouzahuriMinyuTuuti.setHurikaekz37keta3(minyuttAddMsg3);
        kouzahuriMinyuTuuti.setHurikaekz37keta4(minyuttAddMsg4);
        kouzahuriMinyuTuuti.setHurikaekz37keta5(minyuttAddMsg5);
        kouzahuriMinyuTuuti.setHurikaekz37keta6(minyuttAddMsg6);
        kouzahuriMinyuTuuti.setMinyuttaddmsg1(minyuttAddMsg7);
        kouzahuriMinyuTuuti.setMinyuttaddmsg2(minyuttAddMsg8);
        kouzahuriMinyuTuuti.setMinyuttaddmsg3(minyuttAddMsg9);
        kouzahuriMinyuTuuti.setMinyuttaddmsg4(minyuttAddMsg10);
        kouzahuriMinyuTuuti.setMinyuttaddmsg5(minyuttAddMsg11);
        kouzahuriMinyuTuuti.setMinyuttaddmsg6(minyuttAddMsg12);
        kouzahuriMinyuTuuti.setMinyuttaddmsg7(minyuttAddMsg13);
        kouzahuriMinyuTuuti.setMinyuttaddmsg8(minyuttAddMsg14);
        kouzahuriMinyuTuuti.setMinyuttaddmsg9(minyuttAddMsg15);
        kouzahuriMinyuTuuti.setMinyuttaddmsg10(minyuttAddMsg16);
        kouzahuriMinyuTuuti.setMinyuttaddmsg11(minyuttAddMsg17);
        kouzahuriMinyuTuuti.setMinyuttaddmsg12(minyuttAddMsg18);
        kouzahuriMinyuTuuti.setMinyuttaddmsg13(minyuttAddMsg19);
        kouzahuriMinyuTuuti.setMinyuttaddmsg14(minyuttAddMsg20);
        kouzahuriMinyuTuuti.setMinyuttaddmsg15(minyuttAddMsg21);
        kouzahuriMinyuTuuti.setMinyuttaddmsg16(minyuttAddMsg22);
        kouzahuriMinyuTuuti.setMinyuttaddmsg17(minyuttAddMsg23);
        kouzahuriMinyuTuuti.setMinyuttaddmsg18(minyuttAddMsg24);
        kouzahuriMinyuTuuti.setMinyuttaddmsg19(minyuttAddMsg25);
        kouzahuriMinyuTuuti.setMinyuttaddmsg20(minyuttAddMsg26);
        kouzahuriMinyuTuuti.setMinyuttaddmsg21(minyuttAddMsg27);
        kouzahuriMinyuTuuti.setTuutisyuruicd(pTuutisyuruicd);
        kouzahuriMinyuTuuti.setSaikokutuutizumiflg(saikokuTuutiZumiflg);
        kouzahuriMinyuTuuti.setTyouhyoukigoukbn(C_AsTyouhyoukigouKbn.AS_KOUHURIMINYUUTUUTI);
        kouzahuriMinyuTuuti.setHrkkeiro(C_Hrkkeiro.CREDIT);
        kouzahuriMinyuTuuti.setJkipjytym(pEditCreditMinyuuTuutiParam.getJkiPJytYm());
        kouzahuriMinyuTuuti.setGyoumuKousinKinou(pKhozenCommonParam.getFunctionId());
        kouzahuriMinyuTuuti.setGyoumuKousinsyaId(pKhozenCommonParam.getUserID());
        kouzahuriMinyuTuuti.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

        BizPropertyInitializer.initialize(kouzahuriMinyuTuuti);

        return kouzahuriMinyuTuuti;
    }

    public IT_KouzahuriMinyuTuuti editTBL(KhozenCommonParam pKhozenCommonParam,
        IT_KykKihon pKykKihon,
        CreditSaikokuTuutiParam pCreditSaikokuTuutiParam,
        BizDate pSyoriymd,
        C_HassouKbn pHassouKbn,
        String pTuutisyuruicd) {

        String tuutiNm = "";
        C_Skszumiflg saikokuTuutiZumiflg = C_Skszumiflg.MISAKUSEI;
        String  minyuttMsg1 = "";
        String  minyuttMsg2 = "";
        String  minyuttMsg3 = "";
        String  minyuttMsg4 = "";
        String  minyuttMsg5 = "";
        String  minyuttMsg6 = "";
        String  minyuttMsg7 = "";
        String  minyuttMsg8 = "";
        String  minyuttMsg9 = "";
        String  minyuttMsg10 = "";
        String  minyuttMsg11 = "";
        String  minyuttMsg12 = "";
        String hrkHouhou = "";
        String Saikokutukiyykkn1 = "";
        String Saikokutukiyykkn2 = "";
        String nextHurikaeNaiyou1 = "";
        String nextHurikaeNaiyou2 = "";
        String nextHurikaeNaiyou3 = "";
        String minyuttAddMsg1 = "";
        String minyuttAddMsg2 = "";
        String minyuttAddMsg3 = "";
        String minyuttAddMsg4 = "";
        String minyuttAddMsg5 = "";
        String minyuttAddMsg6 = "";
        String minyuttAddMsg7 = "";
        String minyuttAddMsg8 = "";
        String minyuttAddMsg9 = "";
        String minyuttAddMsg10 = "";
        String minyuttAddMsg11 = "";
        String minyuttAddMsg12 = "";
        String minyuttAddMsg13 = "";
        String minyuttAddMsg14 = "";
        String minyuttAddMsg15 = "";
        String minyuttAddMsg16 = "";
        String minyuttAddMsg17 = "";
        String minyuttAddMsg18 = "";
        String minyuttAddMsg19 = "";
        String minyuttAddMsg20 = "";
        String minyuttAddMsg21 = "";
        String minyuttAddMsg22 = "";
        String minyuttAddMsg23 = "";
        String minyuttAddMsg24 = "";
        String minyuttAddMsg25 = "";
        String minyuttAddMsg26 = "";
        String minyuttAddMsg27 = "";

        IT_KykSya kykSya = pKykKihon.getKykSya();

        IT_HhknSya hhknSya = pKykKihon.getHhknSya();

        BzGetSosikiMadogutiInfo bzGetSosikiMadogutiInfo = SWAKInjector.getInstance(BzGetSosikiMadogutiInfo.class);

        BzGetSosikiMadogutiInfoKekkaBean bzGetSosikiMadogutiInfoKekkaBean =
            bzGetSosikiMadogutiInfo.exec(YuyuBizConfig.getInstance().getCallcentersosikicd());

        String dispYykknMnryYmd = FixedDateFormatter.formatYMDZenkakuSeirekiKanji(
            pCreditSaikokuTuutiParam.getYykknMnryYmd());

        String dispJikaiUrskbi = FixedDateFormatter.formatYMDZenkakuSeirekiKanji(
            pCreditSaikokuTuutiParam.getJikaiUrskbi());

        String dispJkiPJytYm = FixedDateFormatter.formatYMZenkakuSeirekiKanji(
            pCreditSaikokuTuutiParam.getJkiPJytYm().getFirstDay());

        String dispJkiPJytY = FixedDateFormatter.formatYZenkakuSeirekiKanji(
            pCreditSaikokuTuutiParam.getJkiPJytYm().getFirstDay());

        String dispJkiPJytM = FixedDateFormatter.formatMZenkakuKanji(
            pCreditSaikokuTuutiParam.getJkiPJytYm().getFirstDay());

        String dispAnnaiGetusuu = Strings.padStart(ConvertUtil.toZenNumeric(
            String.valueOf(pCreditSaikokuTuutiParam.getAnnaiGetusuu())), 2, '　');

        String dispAnnaiKingaku = Strings.padStart(ConvertUtil.toZenAll(
            BizUtil.comma(pCreditSaikokuTuutiParam.getAnnaiKingaku().toAdsoluteString()), 0, 0), 11, '　');

        tuutiNm = KBTUUTINM2;
        saikokuTuutiZumiflg = C_Skszumiflg.SAKUSEIZUMI;

        if (C_UmuKbn.NONE.eq(pCreditSaikokuTuutiParam.getDattaiUktkUmu())) {

            if (C_Yuukoukakkekka.YUUKOUKAK_OK.eq(pCreditSaikokuTuutiParam.getYuukoukakkekka()) &&
                C_CreditUriageNgJiyuuKbn.GENDOGAKUTYOUKA.eq(pCreditSaikokuTuutiParam.getCreditUriageNgJiyuuKbn())) {

                minyuttMsg1 = KBCREDITOSIRASEMSG_COMMON_1;
                minyuttMsg2 = KBCREDITOSIRASEMSG_COMMON_2 + KBCREDITOSIRASEMSG_GNDGK_2;
                minyuttMsg3 = KBCREDITOSIRASEMSG1_GNDGK3_1 + dispJkiPJytYm + KBCREDITOSIRASEMSG1_GNDGK3_2;
                minyuttMsg4 = KBCREDITOSIRASEMSG1_GNDGK_4;
                minyuttMsg5 = KBCREDITOSIRASEMSG1_GNDGK5_1 + dispJikaiUrskbi + KBCREDITOSIRASEMSG1_GNDGK5_2;
                minyuttMsg6 = KBCREDITOSIRASEMSG1_GNDGK_6;
                minyuttMsg7 = KBCREDITOSIRASEMSG1_GNDGK_7;
                minyuttMsg8 = KBCREDITOSIRASEMSG1_GNDGK_8_HRK;
                minyuttMsg9 = KBCREDITOSIRASEMSG1_GNDGK_9_HRK;
                minyuttMsg10 = KBCREDITOSIRASEMSG_COMMON_3;
                minyuttMsg11 = KBCREDITOSIRASEMSG_COMMON_4;
                minyuttMsg12 = KB_BLANK;
            }
        }
        else if (C_UmuKbn.ARI.eq(pCreditSaikokuTuutiParam.getDattaiUktkUmu())) {

            if (C_Yuukoukakkekka.YUUKOUKAK_OK.eq(pCreditSaikokuTuutiParam.getYuukoukakkekka()) &&
                C_CreditUriageNgJiyuuKbn.YUUKOUKIGENERROR.eq(pCreditSaikokuTuutiParam.getCreditUriageNgJiyuuKbn())) {

                minyuttMsg1 = KBCREDITOSIRASEMSG_COMMON_1;
                minyuttMsg2 = KBCREDITOSIRASEMSG_COMMON_2 + KBCREDITOSIRASEMSG_DATTAITYU_2;
                minyuttMsg3 = KBCREDITOSIRASEMSG_DATTAITYU_3_1 + dispJkiPJytYm + KBCREDITOSIRASEMSG_DATTAITYU_3_2;
                minyuttMsg4 = KBCREDITOSIRASEMSG_DATTAITYU_4_1;
                minyuttMsg5 = KBCREDITOSIRASEMSG_DATTAITYU_5_HRK;
                minyuttMsg6 = KBCREDITOSIRASEMSG_DATTAITYU_6_HRK;
                minyuttMsg7 = KBCREDITOSIRASEMSG_DATTAITYU_7_HRK;
                minyuttMsg8 = KBCREDITOSIRASEMSG_DATTAITYU_8_HRK;
                minyuttMsg9 = KBCREDITOSIRASEMSG_COMMON_3;
                minyuttMsg10 = KBCREDITOSIRASEMSG_COMMON_4;
                minyuttMsg11 = KB_BLANK;
                minyuttMsg12 = KB_BLANK;
            }
            else if (C_Yuukoukakkekka.YUUKOUKAK_NG.eq(pCreditSaikokuTuutiParam.getYuukoukakkekka()) &&
                C_DattairiyuuKbn.HRHENKIBOU.eq(pCreditSaikokuTuutiParam.getDattaiRiyuuKbn()) &&
                C_Dattaikeiro.CREDIT.eq(pCreditSaikokuTuutiParam.getDattaikeiro())) {

                minyuttMsg1 = KBCREDITOSIRASEMSG_COMMON_1;
                minyuttMsg2 = KBCREDITOSIRASEMSG_COMMON_2 + KBCREDITOSIRASEMSG2_YUUKSNG_2;
                minyuttMsg3 = KBCREDITOSIRASEMSG2_YUUKSNG_3;
                minyuttMsg4 = KBCREDITOSIRASEMSG2_YUUKSNG_4 + dispJkiPJytY;
                minyuttMsg5 = dispJkiPJytM + KBCREDITOSIRASEMSG2_YUUKSNG_5;
                minyuttMsg6 = KBCREDITOSIRASEMSG2_YUUKSNG_6_HRK;
                minyuttMsg7 = KBCREDITOSIRASEMSG2_YUUKSNG_7_HRK;
                minyuttMsg8 = KBCREDITOSIRASEMSG2_YUUKSNG_8_HRK;
                minyuttMsg9 = KBCREDITOSIRASEMSG2_YUUKSNG_9_HRK;
                minyuttMsg10 = KBCREDITOSIRASEMSG_COMMON_3;
                minyuttMsg11 = KBCREDITOSIRASEMSG_COMMON_4;
                minyuttMsg12 = KB_BLANK;
            }
            else if (C_Dattaikeiro.ONLINE.eq(pCreditSaikokuTuutiParam.getDattaikeiro())) {

                if (C_DattairiyuuKbn.HRHENKIBOU.eq(pCreditSaikokuTuutiParam.getDattaiRiyuuKbn())) {

                    minyuttMsg1 = KBCREDITOSIRASEMSG_COMMON_1;
                    minyuttMsg2 = KBCREDITOSIRASEMSG_COMMON_2 + KBCREDITOSIRASEMSG_DATTAITYU_2;
                    minyuttMsg3 = KBCREDITOSIRASEMSG_DATTAITYU_3_1 + dispJkiPJytYm + KBCREDITOSIRASEMSG_DATTAITYU_3_2;
                    minyuttMsg4 = KBCREDITOSIRASEMSG_DATTAITYU_4_1 + KBCREDITOSIRASEMSG_DATTAITYU_4_HRH
                        + KBCREDITOSIRASEMSG_DATTAITYU_4_2;
                    minyuttMsg5 = KBCREDITOSIRASEMSG_DATTAITYU_5_HRK;
                    minyuttMsg6 = KBCREDITOSIRASEMSG_DATTAITYU_6_HRK;
                    minyuttMsg7 = KBCREDITOSIRASEMSG_DATTAITYU_7_HRK;
                    minyuttMsg8 = KBCREDITOSIRASEMSG_DATTAITYU_8_HRK;
                    minyuttMsg9 = KBCREDITOSIRASEMSG_COMMON_3;
                    minyuttMsg10 = KBCREDITOSIRASEMSG_COMMON_4;
                    minyuttMsg11 = KB_BLANK;
                    minyuttMsg12 = KB_BLANK;
                }

                else if (C_DattairiyuuKbn.KAIYAKUKIBOU.eq(pCreditSaikokuTuutiParam.getDattaiRiyuuKbn())) {

                    minyuttMsg1 = KBCREDITOSIRASEMSG_COMMON_1;
                    minyuttMsg2 = KBCREDITOSIRASEMSG_COMMON_2 + KBCREDITOSIRASEMSG_DATTAITYU_2;
                    minyuttMsg3 = KBCREDITOSIRASEMSG_DATTAITYU_3_1 + dispJkiPJytYm + KBCREDITOSIRASEMSG_DATTAITYU_3_2;
                    minyuttMsg4 = KBCREDITOSIRASEMSG_DATTAITYU_4_1 + KBCREDITOSIRASEMSG_DATTAITYU_4_KAIYK
                        + KBCREDITOSIRASEMSG_DATTAITYU_4_2;
                    minyuttMsg5 = KBCREDITOSIRASEMSG_DATTAITYU_5_HRK;
                    minyuttMsg6 = KBCREDITOSIRASEMSG_DATTAITYU_6_HRK;
                    minyuttMsg7 = KBCREDITOSIRASEMSG_DATTAITYU_7_HRK;
                    minyuttMsg8 = KBCREDITOSIRASEMSG_DATTAITYU_8_HRK;
                    minyuttMsg9 = KBCREDITOSIRASEMSG_COMMON_3;
                    minyuttMsg10 = KBCREDITOSIRASEMSG_COMMON_4;
                    minyuttMsg11 = KB_BLANK;
                    minyuttMsg12 = KB_BLANK;
                }

                else if (C_DattairiyuuKbn.KEIYAKUHENKOUARI.eq(pCreditSaikokuTuutiParam.getDattaiRiyuuKbn())) {

                    minyuttMsg1 = KBCREDITOSIRASEMSG_COMMON_1;
                    minyuttMsg2 = KBCREDITOSIRASEMSG_COMMON_2 + KBCREDITOSIRASEMSG_DATTAITYU_2;
                    minyuttMsg3 = KBCREDITOSIRASEMSG_DATTAITYU_3_1 + dispJkiPJytYm + KBCREDITOSIRASEMSG_DATTAITYU_3_2;
                    minyuttMsg4 = KBCREDITOSIRASEMSG_DATTAITYU_4_1 + KBCREDITOSIRASEMSG_DATTAITYU_4_KH
                        + KBCREDITOSIRASEMSG_DATTAITYU_4_2;
                    minyuttMsg5 = KBCREDITOSIRASEMSG_DATTAITYU_5_HRK;
                    minyuttMsg6 = KBCREDITOSIRASEMSG_DATTAITYU_6_HRK;
                    minyuttMsg7 = KBCREDITOSIRASEMSG_DATTAITYU_7_HRK;
                    minyuttMsg8 = KBCREDITOSIRASEMSG_DATTAITYU_8_HRK;
                    minyuttMsg9 = KBCREDITOSIRASEMSG_COMMON_3;
                    minyuttMsg10 = KBCREDITOSIRASEMSG_COMMON_4;
                    minyuttMsg11 = KB_BLANK;
                    minyuttMsg12 = KB_BLANK;
                }

                else if (C_DattairiyuuKbn.OTHER.eq(pCreditSaikokuTuutiParam.getDattaiRiyuuKbn())) {

                    minyuttMsg1 = KBCREDITOSIRASEMSG_COMMON_1;
                    minyuttMsg2 = KBCREDITOSIRASEMSG_COMMON_2 + KBCREDITOSIRASEMSG_DATTAITYU_2;
                    minyuttMsg3 = KBCREDITOSIRASEMSG_DATTAITYU_3_1 + dispJkiPJytYm + KBCREDITOSIRASEMSG_DATTAITYU_3_2;
                    minyuttMsg4 = KBCREDITOSIRASEMSG_DATTAITYU_4_1;
                    minyuttMsg5 = KBCREDITOSIRASEMSG_DATTAITYU_5_HRK;
                    minyuttMsg6 = KBCREDITOSIRASEMSG_DATTAITYU_6_HRK;
                    minyuttMsg7 = KBCREDITOSIRASEMSG_DATTAITYU_7_HRK;
                    minyuttMsg8 = KBCREDITOSIRASEMSG_DATTAITYU_8_HRK;
                    minyuttMsg9 = KBCREDITOSIRASEMSG_COMMON_3;
                    minyuttMsg10 = KBCREDITOSIRASEMSG_COMMON_4;
                    minyuttMsg11 = KB_BLANK;
                    minyuttMsg12 = KB_BLANK;
                }
            }
        }

        hrkHouhou = pKykKihon.getHrkkaisuu().getContent();

        if (C_UmuKbn.NONE.eq(pCreditSaikokuTuutiParam.getDattaiUktkUmu())) {

            if (C_Yuukoukakkekka.YUUKOUKAK_OK.eq(pCreditSaikokuTuutiParam.getYuukoukakkekka()) &&
                C_CreditUriageNgJiyuuKbn.GENDOGAKUTYOUKA.eq(pCreditSaikokuTuutiParam.getCreditUriageNgJiyuuKbn())) {

                nextHurikaeNaiyou1 = KBCREDITNEXTHURIKAENAIYOU_GNDGK_1;
                nextHurikaeNaiyou2 = KBNEXTHURIKAEMAIYOU1_2_1 + dispAnnaiKingaku + KBNEXTHURIKAEMAIYOU1_2_2 + dispJkiPJytYm
                    + KBNEXTHURIKAEMAIYOU1_2_3 + dispAnnaiGetusuu + KBNEXTHURIKAEMAIYOU1_2_4;
                nextHurikaeNaiyou3 = KBNEXTHURIKAEMAIYOU1_3;
            }
        }
        else if (C_UmuKbn.ARI.eq(pCreditSaikokuTuutiParam.getDattaiUktkUmu())) {

            nextHurikaeNaiyou1 = KBNEXTHURIKAEMAIYOU1_1;
            nextHurikaeNaiyou2 = KBNEXTHURIKAEMAIYOU1_2_1 + dispAnnaiKingaku + KBNEXTHURIKAEMAIYOU1_2_2 + dispJkiPJytYm
                + KBNEXTHURIKAEMAIYOU1_2_3 + dispAnnaiGetusuu + KBNEXTHURIKAEMAIYOU1_2_4;
            nextHurikaeNaiyou3 = KBNEXTHURIKAEMAIYOU1_3;
        }

        Saikokutukiyykkn1 = dispJkiPJytM + KBSAIKOKUKIYYKKN_HRKKIGEN_1;
        Saikokutukiyykkn2 = KBSAIKOKUKIYYKKN2 + dispYykknMnryYmd;

        if (C_UmuKbn.NONE.eq(pCreditSaikokuTuutiParam.getDattaiUktkUmu())) {

            if (C_Yuukoukakkekka.YUUKOUKAK_OK.eq(pCreditSaikokuTuutiParam.getYuukoukakkekka()) &&
                C_CreditUriageNgJiyuuKbn.GENDOGAKUTYOUKA.eq(pCreditSaikokuTuutiParam.getCreditUriageNgJiyuuKbn())) {

                minyuttAddMsg1 = KB_BLANK;
                minyuttAddMsg2 = KBCREDITADDMSG_SAIKOKU_1;
                minyuttAddMsg3 = KBCREDITADDMSG_SAIKOKU_2;
                minyuttAddMsg4 = KBCREDITADDMSG_COMMON_2;
                minyuttAddMsg5 = KBCREDITADDMSG_COMMON_3;
                minyuttAddMsg6 = KBCREDITADDMSG_COMMON_1;
                minyuttAddMsg7 = KBCREDITADDMSG1_GNDGK1;
                minyuttAddMsg8 = KBCREDITADDMSG1_GNDGK2;
                minyuttAddMsg9 = KBCREDITADDMSG1_GNDGK3;
                minyuttAddMsg10 = KBCREDITADDMSG1_GNDGK_HRK_1;
                minyuttAddMsg11 = KBCREDITADDMSG1_GNDGK_HRK_2;
                minyuttAddMsg12 = KBCREDITADDMSG_COMMON_4;
                minyuttAddMsg13 = KBCREDITADDMSG_COMMON_5;
                minyuttAddMsg14 = KBCREDITADDMSG_COMMON_6;
                minyuttAddMsg15 = KBCREDITADDMSG_COMMON_7;
                minyuttAddMsg16 = KBCREDITADDMSG_COMMON_12;
                minyuttAddMsg17 = KBCREDITADDMSG_COMMON_13;
                minyuttAddMsg18 = KBCREDITADDMSG_COMMON_14;
                minyuttAddMsg19 = KB_BLANK;
                minyuttAddMsg20 = KB_BLANK;
                minyuttAddMsg21 = KB_BLANK;
                minyuttAddMsg22 = KB_BLANK;
                minyuttAddMsg23 = KB_BLANK;
                minyuttAddMsg24 = KB_BLANK;
                minyuttAddMsg25 = KB_BLANK;
                minyuttAddMsg26 = KB_BLANK;
                minyuttAddMsg27 = KB_BLANK;
            }
        }
        else if (C_UmuKbn.ARI.eq(pCreditSaikokuTuutiParam.getDattaiUktkUmu())) {

            if (C_Yuukoukakkekka.YUUKOUKAK_OK.eq(pCreditSaikokuTuutiParam.getYuukoukakkekka())) {

                if (C_CreditUriageNgJiyuuKbn.YUUKOUKIGENERROR.eq(
                    pCreditSaikokuTuutiParam.getCreditUriageNgJiyuuKbn())) {

                    minyuttAddMsg1 = KB_BLANK;
                    minyuttAddMsg2 = KBCREDITADDMSG_SAIKOKU_1;
                    minyuttAddMsg3 = KBCREDITADDMSG_SAIKOKU_2;
                    minyuttAddMsg4 = KBCREDITADDMSG_COMMON_2;
                    minyuttAddMsg5 = KBCREDITADDMSG_COMMON_3;
                    minyuttAddMsg6 = KBCREDITADDMSG_COMMON_1;
                    minyuttAddMsg7 = KBCREDITADDMSG_COMMON_4;
                    minyuttAddMsg8 = KBCREDITADDMSG_COMMON_5;
                    minyuttAddMsg9 = KBCREDITADDMSG_COMMON_6;
                    minyuttAddMsg10 = KBCREDITADDMSG_COMMON_7;
                    minyuttAddMsg11 = KBCREDITADDMSG2_YKKIGENKIRE_1;
                    minyuttAddMsg12 = KBCREDITADDMSG2_YKKIGENKIRE_2;
                    minyuttAddMsg13 = KBCREDITADDMSG2_YKKIGENKIRE_3;
                    minyuttAddMsg14 = KBCREDITADDMSG2_YKKIGENKIRE_4;
                    minyuttAddMsg15 = KBCREDITADDMSG2_YKKIGENKIRE_5;
                    minyuttAddMsg16 = KBCREDITADDMSG2_YKKIGENKIRE_6;
                    minyuttAddMsg17 = KBCREDITADDMSG2_YKKIGENKIRE_7;
                    minyuttAddMsg18 = KBCREDITADDMSG2_YKKIGENKIRE_8_HRK;
                    minyuttAddMsg19 = KBCREDITADDMSG2_YKKIGENKIRE_9;
                    minyuttAddMsg20 = KBCREDITADDMSG2_YKKIGENKIRE_10;
                    minyuttAddMsg21 = KBCREDITADDMSG2_YKKIGENKIRE_11;
                    minyuttAddMsg22 = KBCREDITADDMSG_COMMON_12;
                    minyuttAddMsg23 = KBCREDITADDMSG_COMMON_13;
                    minyuttAddMsg24 = KBCREDITADDMSG_COMMON_14;
                    minyuttAddMsg25 = KB_BLANK;
                    minyuttAddMsg26 = KB_BLANK;
                    minyuttAddMsg27 = KB_BLANK;
                }
                else if (C_Dattaikeiro.ONLINE.eq(pCreditSaikokuTuutiParam.getDattaikeiro())) {

                    if (C_DattairiyuuKbn.HRHENKIBOU.eq(pCreditSaikokuTuutiParam.getDattaiRiyuuKbn())) {

                        minyuttAddMsg1 = KB_BLANK;
                        minyuttAddMsg2 = KBCREDITADDMSG_SAIKOKU_1;
                        minyuttAddMsg3 = KBCREDITADDMSG_SAIKOKU_2;
                        minyuttAddMsg4 = KBCREDITADDMSG_COMMON_2;
                        minyuttAddMsg5 = KBCREDITADDMSG_COMMON_3;
                        minyuttAddMsg6 = KBCREDITADDMSG_COMMON_1;
                        minyuttAddMsg7 = KBCREDITADDMSG_COMMON_4;
                        minyuttAddMsg8 = KBCREDITADDMSG_COMMON_5;
                        minyuttAddMsg9 = KBCREDITADDMSG_COMMON_6;
                        minyuttAddMsg10 = KBCREDITADDMSG_COMMON_7;
                        minyuttAddMsg11 = KBCREDITADDMSG3_DATTAITYU_1_HRH;
                        minyuttAddMsg12 = KBCREDITADDMSG3_DATTAITYU_2_HRH;
                        minyuttAddMsg13 = KBCREDITADDMSG3_DATTAITYU_3_HRH;
                        minyuttAddMsg14 = KBCREDITADDMSG3_DATTAITYU_4_HRH;
                        minyuttAddMsg15 = KBCREDITADDMSG_COMMON_12;
                        minyuttAddMsg16 = KBCREDITADDMSG_COMMON_13;
                        minyuttAddMsg17 = KBCREDITADDMSG_COMMON_14;
                        minyuttAddMsg18 = KB_BLANK;
                        minyuttAddMsg19 = KB_BLANK;
                        minyuttAddMsg20 = KB_BLANK;
                        minyuttAddMsg21 = KB_BLANK;
                        minyuttAddMsg22 = KB_BLANK;
                        minyuttAddMsg23 = KB_BLANK;
                        minyuttAddMsg24 = KB_BLANK;
                        minyuttAddMsg25 = KB_BLANK;
                        minyuttAddMsg26 = KB_BLANK;
                        minyuttAddMsg27 = KB_BLANK;
                    }
                    else if (C_DattairiyuuKbn.KAIYAKUKIBOU.eq(pCreditSaikokuTuutiParam.getDattaiRiyuuKbn())) {

                        minyuttAddMsg1 = KB_BLANK;
                        minyuttAddMsg2 = KBCREDITADDMSG_SAIKOKU_1;
                        minyuttAddMsg3 = KBCREDITADDMSG_SAIKOKU_2;
                        minyuttAddMsg4 = KBCREDITADDMSG_COMMON_2;
                        minyuttAddMsg5 = KBCREDITADDMSG_COMMON_3;
                        minyuttAddMsg6 = KBCREDITADDMSG_COMMON_1;
                        minyuttAddMsg7 = KBCREDITADDMSG_COMMON_4;
                        minyuttAddMsg8 = KBCREDITADDMSG_COMMON_5;
                        minyuttAddMsg9 = KBCREDITADDMSG_COMMON_6;
                        minyuttAddMsg10 = KBCREDITADDMSG_COMMON_7;
                        minyuttAddMsg11 = KBCREDITADDMSG5_DATTAITYU_1_KAIYK;
                        minyuttAddMsg12 = KBCREDITADDMSG5_DATTAITYU_2_KAIYK;
                        minyuttAddMsg13 = KBCREDITADDMSG5_DATTAITYU_3_KAIYK;
                        minyuttAddMsg14 = KBCREDITADDMSG_COMMON_12;
                        minyuttAddMsg15 = KBCREDITADDMSG_COMMON_13;
                        minyuttAddMsg16 = KBCREDITADDMSG_COMMON_14;
                        minyuttAddMsg17 = KB_BLANK;
                        minyuttAddMsg18 = KB_BLANK;
                        minyuttAddMsg19 = KB_BLANK;
                        minyuttAddMsg20 = KB_BLANK;
                        minyuttAddMsg21 = KB_BLANK;
                        minyuttAddMsg22 = KB_BLANK;
                        minyuttAddMsg23 = KB_BLANK;
                        minyuttAddMsg24 = KB_BLANK;
                        minyuttAddMsg25 = KB_BLANK;
                        minyuttAddMsg26 = KB_BLANK;
                        minyuttAddMsg27 = KB_BLANK;
                    }
                    else if (C_DattairiyuuKbn.KEIYAKUHENKOUARI.eq(pCreditSaikokuTuutiParam.getDattaiRiyuuKbn())) {

                        minyuttAddMsg1 = KB_BLANK;
                        minyuttAddMsg2 = KBCREDITADDMSG_SAIKOKU_1;
                        minyuttAddMsg3 = KBCREDITADDMSG_SAIKOKU_2;
                        minyuttAddMsg4 = KBCREDITADDMSG_COMMON_2;
                        minyuttAddMsg5 = KBCREDITADDMSG_COMMON_3;
                        minyuttAddMsg6 = KBCREDITADDMSG_COMMON_1;
                        minyuttAddMsg7 = KBCREDITADDMSG_COMMON_4;
                        minyuttAddMsg8 = KBCREDITADDMSG_COMMON_5;
                        minyuttAddMsg9 = KBCREDITADDMSG_COMMON_6;
                        minyuttAddMsg10 = KBCREDITADDMSG_COMMON_7;
                        minyuttAddMsg11 = KBCREDITADDMSG4_DATTAITYU_1_KH;
                        minyuttAddMsg12 = KBCREDITADDMSG4_DATTAITYU_2_KH;
                        minyuttAddMsg13 = KBCREDITADDMSG4_DATTAITYU_3_KH;
                        minyuttAddMsg14 = KBCREDITADDMSG4_DATTAITYU_4_KH;
                        minyuttAddMsg15 = KBCREDITADDMSG_COMMON_12;
                        minyuttAddMsg16 = KBCREDITADDMSG_COMMON_13;
                        minyuttAddMsg17 = KBCREDITADDMSG_COMMON_14;
                        minyuttAddMsg18 = KB_BLANK;
                        minyuttAddMsg19 = KB_BLANK;
                        minyuttAddMsg20 = KB_BLANK;
                        minyuttAddMsg21 = KB_BLANK;
                        minyuttAddMsg22 = KB_BLANK;
                        minyuttAddMsg23 = KB_BLANK;
                        minyuttAddMsg24 = KB_BLANK;
                        minyuttAddMsg25 = KB_BLANK;
                        minyuttAddMsg26 = KB_BLANK;
                        minyuttAddMsg27 = KB_BLANK;
                    }
                    else if (C_DattairiyuuKbn.OTHER.eq(pCreditSaikokuTuutiParam.getDattaiRiyuuKbn())) {

                        minyuttAddMsg1 = KB_BLANK;
                        minyuttAddMsg2 = KBCREDITADDMSG_SAIKOKU_1;
                        minyuttAddMsg3 = KBCREDITADDMSG_SAIKOKU_2;
                        minyuttAddMsg4 = KBCREDITADDMSG_COMMON_2;
                        minyuttAddMsg5 = KBCREDITADDMSG_COMMON_3;
                        minyuttAddMsg6 = KBCREDITADDMSG_COMMON_1;
                        minyuttAddMsg7 = KBCREDITADDMSG_COMMON_4;
                        minyuttAddMsg8 = KBCREDITADDMSG_COMMON_5;
                        minyuttAddMsg9 = KBCREDITADDMSG_COMMON_6;
                        minyuttAddMsg10 = KBCREDITADDMSG_COMMON_7;
                        minyuttAddMsg11 = KBCREDITADDMSG6_DATTAITYU_1_SONOTA;
                        minyuttAddMsg12 = KBCREDITADDMSG6_DATTAITYU_2_SONOTA;
                        minyuttAddMsg13 = KBCREDITADDMSG_COMMON_12;
                        minyuttAddMsg14 = KBCREDITADDMSG_COMMON_13;
                        minyuttAddMsg15 = KBCREDITADDMSG_COMMON_14;
                        minyuttAddMsg16 = KB_BLANK;
                        minyuttAddMsg17 = KB_BLANK;
                        minyuttAddMsg18 = KB_BLANK;
                        minyuttAddMsg19 = KB_BLANK;
                        minyuttAddMsg20 = KB_BLANK;
                        minyuttAddMsg21 = KB_BLANK;
                        minyuttAddMsg22 = KB_BLANK;
                        minyuttAddMsg23 = KB_BLANK;
                        minyuttAddMsg24 = KB_BLANK;
                        minyuttAddMsg25 = KB_BLANK;
                        minyuttAddMsg26 = KB_BLANK;
                        minyuttAddMsg27 = KB_BLANK;
                    }
                }
            }
            else if (C_Yuukoukakkekka.YUUKOUKAK_NG.eq(pCreditSaikokuTuutiParam.getYuukoukakkekka())) {

                if (C_Dattaikeiro.CREDIT.eq(pCreditSaikokuTuutiParam.getDattaikeiro())) {

                    minyuttAddMsg1 = KB_BLANK;
                    minyuttAddMsg2 = KBCREDITADDMSG_SAIKOKU_1;
                    minyuttAddMsg3 = KBCREDITADDMSG_SAIKOKU_2;
                    minyuttAddMsg4 = KBCREDITADDMSG_COMMON_2;
                    minyuttAddMsg5 = KBCREDITADDMSG_COMMON_3;
                    minyuttAddMsg6 = KBCREDITADDMSG_COMMON_1;
                    minyuttAddMsg7 = KBCREDITADDMSG_COMMON_4;
                    minyuttAddMsg8 = KBCREDITADDMSG_COMMON_5;
                    minyuttAddMsg9 = KBCREDITADDMSG_COMMON_6;
                    minyuttAddMsg10 = KBCREDITADDMSG_COMMON_7;
                    minyuttAddMsg11 = KBCREDITADDMSG7_DATTAITYU_1_NGDATTAI;
                    minyuttAddMsg12 = KBCREDITADDMSG7_DATTAITYU_2_NGDATTAI;
                    minyuttAddMsg13 = KBCREDITADDMSG_COMMON_12;
                    minyuttAddMsg14 = KBCREDITADDMSG_COMMON_13;
                    minyuttAddMsg15 = KBCREDITADDMSG_COMMON_14;
                    minyuttAddMsg16 = KB_BLANK;
                    minyuttAddMsg17 = KB_BLANK;
                    minyuttAddMsg18 = KB_BLANK;
                    minyuttAddMsg19 = KB_BLANK;
                    minyuttAddMsg20 = KB_BLANK;
                    minyuttAddMsg21 = KB_BLANK;
                    minyuttAddMsg22 = KB_BLANK;
                    minyuttAddMsg23 = KB_BLANK;
                    minyuttAddMsg24 = KB_BLANK;
                    minyuttAddMsg25 = KB_BLANK;
                    minyuttAddMsg26 = KB_BLANK;
                    minyuttAddMsg27 = KB_BLANK;
                }
                else if (C_Dattaikeiro.ONLINE.eq(pCreditSaikokuTuutiParam.getDattaikeiro())) {

                    if (C_DattairiyuuKbn.HRHENKIBOU.eq(pCreditSaikokuTuutiParam.getDattaiRiyuuKbn())) {

                        minyuttAddMsg1 = KB_BLANK;
                        minyuttAddMsg2 = KBCREDITADDMSG_SAIKOKU_1;
                        minyuttAddMsg3 = KBCREDITADDMSG_SAIKOKU_2;
                        minyuttAddMsg4 = KBCREDITADDMSG_COMMON_2;
                        minyuttAddMsg5 = KBCREDITADDMSG_COMMON_3;
                        minyuttAddMsg6 = KBCREDITADDMSG_COMMON_1;
                        minyuttAddMsg7 = KBCREDITADDMSG_COMMON_4;
                        minyuttAddMsg8 = KBCREDITADDMSG_COMMON_5;
                        minyuttAddMsg9 = KBCREDITADDMSG_COMMON_6;
                        minyuttAddMsg10 = KBCREDITADDMSG_COMMON_7;
                        minyuttAddMsg11 = KBCREDITADDMSG_COMMON_8;
                        minyuttAddMsg12 = KBCREDITADDMSG_COMMON_9;
                        minyuttAddMsg13 = KBCREDITADDMSG_COMMON_10;
                        minyuttAddMsg14 = KBCREDITADDMSG_COMMON_11;
                        minyuttAddMsg15 = KBCREDITADDMSG3_DATTAITYU_1_HRH;
                        minyuttAddMsg16 = KBCREDITADDMSG3_DATTAITYU_2_HRH;
                        minyuttAddMsg17 = KBCREDITADDMSG3_DATTAITYU_3_HRH;
                        minyuttAddMsg18 = KBCREDITADDMSG3_DATTAITYU_4_HRH;
                        minyuttAddMsg19 = KBCREDITADDMSG_COMMON_12;
                        minyuttAddMsg20 = KBCREDITADDMSG_COMMON_13;
                        minyuttAddMsg21 = KBCREDITADDMSG_COMMON_14;
                        minyuttAddMsg22 = KB_BLANK;
                        minyuttAddMsg23 = KB_BLANK;
                        minyuttAddMsg24 = KB_BLANK;
                        minyuttAddMsg25 = KB_BLANK;
                        minyuttAddMsg26 = KB_BLANK;
                        minyuttAddMsg27 = KB_BLANK;
                    }
                    else if (C_DattairiyuuKbn.KAIYAKUKIBOU.eq(pCreditSaikokuTuutiParam.getDattaiRiyuuKbn())) {

                        minyuttAddMsg1 = KB_BLANK;
                        minyuttAddMsg2 = KBCREDITADDMSG_SAIKOKU_1;
                        minyuttAddMsg3 = KBCREDITADDMSG_SAIKOKU_2;
                        minyuttAddMsg4 = KBCREDITADDMSG_COMMON_2;
                        minyuttAddMsg5 = KBCREDITADDMSG_COMMON_3;
                        minyuttAddMsg6 = KBCREDITADDMSG_COMMON_1;
                        minyuttAddMsg7 = KBCREDITADDMSG_COMMON_4;
                        minyuttAddMsg8 = KBCREDITADDMSG_COMMON_5;
                        minyuttAddMsg9 = KBCREDITADDMSG_COMMON_6;
                        minyuttAddMsg10 = KBCREDITADDMSG_COMMON_7;
                        minyuttAddMsg11 = KBCREDITADDMSG_COMMON_8;
                        minyuttAddMsg12 = KBCREDITADDMSG_COMMON_9;
                        minyuttAddMsg13 = KBCREDITADDMSG_COMMON_10;
                        minyuttAddMsg14 = KBCREDITADDMSG_COMMON_11;
                        minyuttAddMsg15 = KBCREDITADDMSG5_DATTAITYU_1_KAIYK;
                        minyuttAddMsg16 = KBCREDITADDMSG5_DATTAITYU_2_KAIYK;
                        minyuttAddMsg17 = KBCREDITADDMSG5_DATTAITYU_3_KAIYK;
                        minyuttAddMsg18 = KBCREDITADDMSG_COMMON_12;
                        minyuttAddMsg19 = KBCREDITADDMSG_COMMON_13;
                        minyuttAddMsg20 = KBCREDITADDMSG_COMMON_14;
                        minyuttAddMsg21 = KB_BLANK;
                        minyuttAddMsg22 = KB_BLANK;
                        minyuttAddMsg23 = KB_BLANK;
                        minyuttAddMsg24 = KB_BLANK;
                        minyuttAddMsg25 = KB_BLANK;
                        minyuttAddMsg26 = KB_BLANK;
                        minyuttAddMsg27 = KB_BLANK;
                    }
                    else if (C_DattairiyuuKbn.KEIYAKUHENKOUARI.eq(pCreditSaikokuTuutiParam.getDattaiRiyuuKbn())) {

                        minyuttAddMsg1 = KB_BLANK;
                        minyuttAddMsg2 = KBCREDITADDMSG_SAIKOKU_1;
                        minyuttAddMsg3 = KBCREDITADDMSG_SAIKOKU_2;
                        minyuttAddMsg4 = KBCREDITADDMSG_COMMON_2;
                        minyuttAddMsg5 = KBCREDITADDMSG_COMMON_3;
                        minyuttAddMsg6 = KBCREDITADDMSG_COMMON_1;
                        minyuttAddMsg7 = KBCREDITADDMSG_COMMON_4;
                        minyuttAddMsg8 = KBCREDITADDMSG_COMMON_5;
                        minyuttAddMsg9 = KBCREDITADDMSG_COMMON_6;
                        minyuttAddMsg10 = KBCREDITADDMSG_COMMON_7;
                        minyuttAddMsg11 = KBCREDITADDMSG_COMMON_8;
                        minyuttAddMsg12 = KBCREDITADDMSG_COMMON_9;
                        minyuttAddMsg13 = KBCREDITADDMSG_COMMON_10;
                        minyuttAddMsg14 = KBCREDITADDMSG_COMMON_11;
                        minyuttAddMsg15 = KBCREDITADDMSG4_DATTAITYU_1_KH;
                        minyuttAddMsg16 = KBCREDITADDMSG4_DATTAITYU_2_KH;
                        minyuttAddMsg17 = KBCREDITADDMSG4_DATTAITYU_3_KH;
                        minyuttAddMsg18 = KBCREDITADDMSG4_DATTAITYU_4_KH;
                        minyuttAddMsg19 = KBCREDITADDMSG_COMMON_12;
                        minyuttAddMsg20 = KBCREDITADDMSG_COMMON_13;
                        minyuttAddMsg21 = KBCREDITADDMSG_COMMON_14;
                        minyuttAddMsg22 = KB_BLANK;
                        minyuttAddMsg23 = KB_BLANK;
                        minyuttAddMsg24 = KB_BLANK;
                        minyuttAddMsg25 = KB_BLANK;
                        minyuttAddMsg26 = KB_BLANK;
                        minyuttAddMsg27 = KB_BLANK;
                    }
                    else if (C_DattairiyuuKbn.OTHER.eq(pCreditSaikokuTuutiParam.getDattaiRiyuuKbn())) {

                        minyuttAddMsg1 = KB_BLANK;
                        minyuttAddMsg2 = KBCREDITADDMSG_SAIKOKU_1;
                        minyuttAddMsg3 = KBCREDITADDMSG_SAIKOKU_2;
                        minyuttAddMsg4 = KBCREDITADDMSG_COMMON_2;
                        minyuttAddMsg5 = KBCREDITADDMSG_COMMON_3;
                        minyuttAddMsg6 = KBCREDITADDMSG_COMMON_1;
                        minyuttAddMsg7 = KBCREDITADDMSG_COMMON_4;
                        minyuttAddMsg8 = KBCREDITADDMSG_COMMON_5;
                        minyuttAddMsg9 = KBCREDITADDMSG_COMMON_6;
                        minyuttAddMsg10 = KBCREDITADDMSG_COMMON_7;
                        minyuttAddMsg11 = KBCREDITADDMSG6_DATTAITYU_3_SONOTA;
                        minyuttAddMsg12 = KBCREDITADDMSG6_DATTAITYU_4_SONOTA;
                        minyuttAddMsg13 = KBCREDITADDMSG6_DATTAITYU_5_SONOTA;
                        minyuttAddMsg14 = KBCREDITADDMSG6_DATTAITYU_1_SONOTA;
                        minyuttAddMsg15 = KBCREDITADDMSG6_DATTAITYU_2_SONOTA;
                        minyuttAddMsg16 = KBCREDITADDMSG_COMMON_12;
                        minyuttAddMsg17 = KBCREDITADDMSG_COMMON_13;
                        minyuttAddMsg18 = KBCREDITADDMSG_COMMON_14;
                        minyuttAddMsg19 = KB_BLANK;
                        minyuttAddMsg20 = KB_BLANK;
                        minyuttAddMsg21 = KB_BLANK;
                        minyuttAddMsg22 = KB_BLANK;
                        minyuttAddMsg23 = KB_BLANK;
                        minyuttAddMsg24 = KB_BLANK;
                        minyuttAddMsg25 = KB_BLANK;
                        minyuttAddMsg26 = KB_BLANK;
                        minyuttAddMsg27 = KB_BLANK;
                    }
                }
            }
        }

        IT_KouzahuriMinyuTuuti kouzahuriMinyuTuuti = new IT_KouzahuriMinyuTuuti(pKykKihon.getSyono(), pSyoriymd);

        kouzahuriMinyuTuuti.setSyoruiCd(C_SyoruiCdKbn.AS_CREDITMINYUUTUUTI);
        kouzahuriMinyuTuuti.setHassoukbn(pHassouKbn);
        kouzahuriMinyuTuuti.setShskyno(kykSya.getTsinyno());
        kouzahuriMinyuTuuti.setShsadr1kj(kykSya.getTsinadr1kj());
        kouzahuriMinyuTuuti.setShsadr2kj(kykSya.getTsinadr2kj());
        kouzahuriMinyuTuuti.setShsadr3kj(kykSya.getTsinadr3kj());
        kouzahuriMinyuTuuti.setShsnmkj(kykSya.getKyknmkj());
        kouzahuriMinyuTuuti.setToiawasesosikinmkj(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikinm());
        kouzahuriMinyuTuuti.setToiawaseyno(bzGetSosikiMadogutiInfoKekkaBean.getPostalCd());
        kouzahuriMinyuTuuti.setToiawaseadr1kj(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr1());
        kouzahuriMinyuTuuti.setToiawaseadr2kj(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr2());
        kouzahuriMinyuTuuti.setToiawaseadr3kj(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr3());
        kouzahuriMinyuTuuti.setToiawasetelno(bzGetSosikiMadogutiInfoKekkaBean.getTelno());
        kouzahuriMinyuTuuti.setToiawaseteluktkkanou1(YuyuBizConfig.getInstance().getUketimecallcenter1());
        kouzahuriMinyuTuuti.setToiawaseteluktkkanou2(YuyuBizConfig.getInstance().getUketimecallcenter2());
        kouzahuriMinyuTuuti.setTuutinm30keta(tuutiNm);
        kouzahuriMinyuTuuti.setMinyuttmsg1(minyuttMsg1);
        kouzahuriMinyuTuuti.setMinyuttmsg2(minyuttMsg2);
        kouzahuriMinyuTuuti.setMinyuttmsg3(minyuttMsg3);
        kouzahuriMinyuTuuti.setMinyuttmsg4(minyuttMsg4);
        kouzahuriMinyuTuuti.setMinyuttmsg5(minyuttMsg5);
        kouzahuriMinyuTuuti.setMinyuttmsg6(minyuttMsg6);
        kouzahuriMinyuTuuti.setMinyuttmsg7(minyuttMsg7);
        kouzahuriMinyuTuuti.setMinyuttmsg8(minyuttMsg8);
        kouzahuriMinyuTuuti.setMinyuttmsg9(minyuttMsg9);
        kouzahuriMinyuTuuti.setMinyuttmsg10(minyuttMsg10);
        kouzahuriMinyuTuuti.setMinyuttmsg11(minyuttMsg11);
        kouzahuriMinyuTuuti.setMinyuttmsg12(minyuttMsg12);
        kouzahuriMinyuTuuti.setPannainm(KBPANNAINM);
        kouzahuriMinyuTuuti.setHrkhou12keta(hrkHouhou);
        kouzahuriMinyuTuuti.setHhknnmkj(hhknSya.getHhknnmkj());
        kouzahuriMinyuTuuti.setNexthurikaenaiyou1(nextHurikaeNaiyou1);
        kouzahuriMinyuTuuti.setNexthurikaenaiyou2(nextHurikaeNaiyou2);
        kouzahuriMinyuTuuti.setNexthurikaenaiyou3(nextHurikaeNaiyou3);
        kouzahuriMinyuTuuti.setSaikokutukiyykkn1(Saikokutukiyykkn1);
        kouzahuriMinyuTuuti.setSaikokutukiyykkn2(Saikokutukiyykkn2);
        kouzahuriMinyuTuuti.setHrkmirmsg1(KB_BLANK);
        kouzahuriMinyuTuuti.setHrkmirmsg2(KB_BLANK);
        kouzahuriMinyuTuuti.setHrkmirmsg3(KB_BLANK);
        kouzahuriMinyuTuuti.setZenhurikaenaiyou1(KB_BLANK);
        kouzahuriMinyuTuuti.setZenhurikaenaiyou2(KB_BLANK);
        kouzahuriMinyuTuuti.setZenhurikaenaiyou3(KB_BLANK);
        kouzahuriMinyuTuuti.setZenhurikaenaiyou4(KB_BLANK);
        kouzahuriMinyuTuuti.setHurikaekz37keta1(minyuttAddMsg1);
        kouzahuriMinyuTuuti.setHurikaekz37keta2(minyuttAddMsg2);
        kouzahuriMinyuTuuti.setHurikaekz37keta3(minyuttAddMsg3);
        kouzahuriMinyuTuuti.setHurikaekz37keta4(minyuttAddMsg4);
        kouzahuriMinyuTuuti.setHurikaekz37keta5(minyuttAddMsg5);
        kouzahuriMinyuTuuti.setHurikaekz37keta6(minyuttAddMsg6);
        kouzahuriMinyuTuuti.setMinyuttaddmsg1(minyuttAddMsg7);
        kouzahuriMinyuTuuti.setMinyuttaddmsg2(minyuttAddMsg8);
        kouzahuriMinyuTuuti.setMinyuttaddmsg3(minyuttAddMsg9);
        kouzahuriMinyuTuuti.setMinyuttaddmsg4(minyuttAddMsg10);
        kouzahuriMinyuTuuti.setMinyuttaddmsg5(minyuttAddMsg11);
        kouzahuriMinyuTuuti.setMinyuttaddmsg6(minyuttAddMsg12);
        kouzahuriMinyuTuuti.setMinyuttaddmsg7(minyuttAddMsg13);
        kouzahuriMinyuTuuti.setMinyuttaddmsg8(minyuttAddMsg14);
        kouzahuriMinyuTuuti.setMinyuttaddmsg9(minyuttAddMsg15);
        kouzahuriMinyuTuuti.setMinyuttaddmsg10(minyuttAddMsg16);
        kouzahuriMinyuTuuti.setMinyuttaddmsg11(minyuttAddMsg17);
        kouzahuriMinyuTuuti.setMinyuttaddmsg12(minyuttAddMsg18);
        kouzahuriMinyuTuuti.setMinyuttaddmsg13(minyuttAddMsg19);
        kouzahuriMinyuTuuti.setMinyuttaddmsg14(minyuttAddMsg20);
        kouzahuriMinyuTuuti.setMinyuttaddmsg15(minyuttAddMsg21);
        kouzahuriMinyuTuuti.setMinyuttaddmsg16(minyuttAddMsg22);
        kouzahuriMinyuTuuti.setMinyuttaddmsg17(minyuttAddMsg23);
        kouzahuriMinyuTuuti.setMinyuttaddmsg18(minyuttAddMsg24);
        kouzahuriMinyuTuuti.setMinyuttaddmsg19(minyuttAddMsg25);
        kouzahuriMinyuTuuti.setMinyuttaddmsg20(minyuttAddMsg26);
        kouzahuriMinyuTuuti.setMinyuttaddmsg21(minyuttAddMsg27);
        kouzahuriMinyuTuuti.setTuutisyuruicd(pTuutisyuruicd);
        kouzahuriMinyuTuuti.setSaikokutuutizumiflg(saikokuTuutiZumiflg);
        kouzahuriMinyuTuuti.setTyouhyoukigoukbn(C_AsTyouhyoukigouKbn.AS_SAIKOKUTUUTI);
        kouzahuriMinyuTuuti.setHrkkeiro(C_Hrkkeiro.CREDIT);
        kouzahuriMinyuTuuti.setJkipjytym(pCreditSaikokuTuutiParam.getJkiPJytYm());
        kouzahuriMinyuTuuti.setGyoumuKousinKinou(pKhozenCommonParam.getFunctionId());
        kouzahuriMinyuTuuti.setGyoumuKousinsyaId(pKhozenCommonParam.getUserID());
        kouzahuriMinyuTuuti.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

        BizPropertyInitializer.initialize(kouzahuriMinyuTuuti);

        return kouzahuriMinyuTuuti;
    }
}
