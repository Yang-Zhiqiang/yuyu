package yuyu.batch.suuri.srsuuritoukei.srsibouritutoukeiseibigorendou;

import yuyu.def.db.entity.ZT_SbRituToukeiSeibiRenTy;

import com.google.common.base.Strings;

/**
 * 数理統計 数理統計 死亡率統計整備後連動情報コンバーター
 */
public class SrSibourituToukeiSeibigoRendouConverter {

    public static void convertPadding(ZT_SbRituToukeiSeibiRenTy pZtSbRituToukeiSeibiRenTy) {

        pZtSbRituToukeiSeibiRenTy.setZtylnkeikaym(
            Strings.padStart(pZtSbRituToukeiSeibiRenTy.getZtylnkeikaym(), 4, '0'));
        pZtSbRituToukeiSeibiRenTy.setZtylnshrgenincd(
            Strings.padStart(pZtSbRituToukeiSeibiRenTy.getZtylnshrgenincd(), 4, '0'));
        pZtSbRituToukeiSeibiRenTy.setZtypmenjikohasseiymd(
            Strings.padStart(pZtSbRituToukeiSeibiRenTy.getZtypmenjikohasseiymd(), 8, '0'));
        pZtSbRituToukeiSeibiRenTy.setZtygnspshrkeikaym(
            Strings.padStart(pZtSbRituToukeiSeibiRenTy.getZtygnspshrkeikaym(), 4, '0'));
        pZtSbRituToukeiSeibiRenTy.setZtygnspshrgenincd(
            Strings.padStart(pZtSbRituToukeiSeibiRenTy.getZtygnspshrgenincd(), 4, '0'));
        pZtSbRituToukeiSeibiRenTy.setZtygnspshrhyj(
            Strings.padStart(pZtSbRituToukeiSeibiRenTy.getZtygnspshrhyj(), 1, '0'));
        pZtSbRituToukeiSeibiRenTy.setZtysyeiebnri1(
            Strings.padStart(pZtSbRituToukeiSeibiRenTy.getZtysyeiebnri1(), 1, '0'));
        pZtSbRituToukeiSeibiRenTy.setZtysyeiebnri2(
            Strings.padStart(pZtSbRituToukeiSeibiRenTy.getZtysyeiebnri2(), 1, '0'));
        pZtSbRituToukeiSeibiRenTy.setZtyminnesotacd1(
            Strings.padStart(pZtSbRituToukeiSeibiRenTy.getZtyminnesotacd1(), 2, '0'));
        pZtSbRituToukeiSeibiRenTy.setZtyminnesotacd2(
            Strings.padStart(pZtSbRituToukeiSeibiRenTy.getZtyminnesotacd2(), 2, '0'));
        pZtSbRituToukeiSeibiRenTy.setZtyminnesotacd3(
            Strings.padStart(pZtSbRituToukeiSeibiRenTy.getZtyminnesotacd3(), 2, '0'));
        pZtSbRituToukeiSeibiRenTy.setZtyminnesotacd4(
            Strings.padStart(pZtSbRituToukeiSeibiRenTy.getZtyminnesotacd4(), 2, '0'));
        pZtSbRituToukeiSeibiRenTy.setZtyminnesotacd5(
            Strings.padStart(pZtSbRituToukeiSeibiRenTy.getZtyminnesotacd5(), 2, '0'));
        pZtSbRituToukeiSeibiRenTy.setZtylivingneedsshrarihyj(
            Strings.padStart(pZtSbRituToukeiSeibiRenTy.getZtylivingneedsshrarihyj(), 1, '0'));
        pZtSbRituToukeiSeibiRenTy.setZtysykgycd(Strings.padStart(pZtSbRituToukeiSeibiRenTy.getZtysykgycd(), 3, '0'));
        pZtSbRituToukeiSeibiRenTy.setZtyaatukaisosikicd(
            Strings.padStart(pZtSbRituToukeiSeibiRenTy.getZtyaatukaisosikicd(), 7, '0'));
        pZtSbRituToukeiSeibiRenTy.setZtyaatukaikojincd(
            Strings.padStart(pZtSbRituToukeiSeibiRenTy.getZtyaatukaikojincd(), 6, '0'));
        pZtSbRituToukeiSeibiRenTy.setZtyannaifuyouriyuukbn(
            Strings.padStart(pZtSbRituToukeiSeibiRenTy.getZtyannaifuyouriyuukbn(), 2, '0'));
        pZtSbRituToukeiSeibiRenTy.setZtykawaseratetekiyouymd(
            Strings.padStart(pZtSbRituToukeiSeibiRenTy.getZtykawaseratetekiyouymd(), 8, '0'));
        pZtSbRituToukeiSeibiRenTy.setZtyikoujisnskbn(
            Strings.padStart(pZtSbRituToukeiSeibiRenTy.getZtyikoujisnskbn(), 1, '0'));
        pZtSbRituToukeiSeibiRenTy.setZtyihukutyakudatukahikbn(
            Strings.padStart(pZtSbRituToukeiSeibiRenTy.getZtyihukutyakudatukahikbn(), 1, '0'));
        pZtSbRituToukeiSeibiRenTy.setZtyijitoukeiyuksnhyj(
            Strings.padStart(pZtSbRituToukeiSeibiRenTy.getZtyijitoukeiyuksnhyj(), 1, '0'));
        pZtSbRituToukeiSeibiRenTy.setZtykaijyokbn(
            Strings.padStart(pZtSbRituToukeiSeibiRenTy.getZtykaijyokbn(), 1, '0'));
        pZtSbRituToukeiSeibiRenTy.setZtysotodasiphkbnmnoshyouji(
            Strings.padStart(pZtSbRituToukeiSeibiRenTy.getZtysotodasiphkbnmnoshyouji(), 1, '0'));
        pZtSbRituToukeiSeibiRenTy.setZtystdsstkjytkyuhyj(
            Strings.padStart(pZtSbRituToukeiSeibiRenTy.getZtystdsstkjytkyuhyj(), 1, '0'));
        pZtSbRituToukeiSeibiRenTy.setZtygituyuknkbn1(
            Strings.padStart(pZtSbRituToukeiSeibiRenTy.getZtygituyuknkbn1(), 1, '0'));
        pZtSbRituToukeiSeibiRenTy.setZtygituyuknkbn2(
            Strings.padStart(pZtSbRituToukeiSeibiRenTy.getZtygituyuknkbn2(), 1, '0'));
        pZtSbRituToukeiSeibiRenTy.setZtyknkuhnsindanjiyuu(
            Strings.padStart(pZtSbRituToukeiSeibiRenTy.getZtyknkuhnsindanjiyuu(), 1, '0'));
        pZtSbRituToukeiSeibiRenTy.setZtykituenhonsuu(
            Strings.padStart(pZtSbRituToukeiSeibiRenTy.getZtykituenhonsuu(), 2, '0'));
        pZtSbRituToukeiSeibiRenTy.setZtykykjiqpackhyj(
            Strings.padStart(pZtSbRituToukeiSeibiRenTy.getZtykykjiqpackhyj(), 1, '0'));
        pZtSbRituToukeiSeibiRenTy.setZtykeikaym(
            Strings.padStart(pZtSbRituToukeiSeibiRenTy.getZtykeikaym(), 4, '0'));
        pZtSbRituToukeiSeibiRenTy.setZtyksnym(
            Strings.padStart(pZtSbRituToukeiSeibiRenTy.getZtyksnym(), 6, '0'));
        pZtSbRituToukeiSeibiRenTy.setZtysaimnkkykhyj(
            Strings.padStart(pZtSbRituToukeiSeibiRenTy.getZtysaimnkkykhyj(), 1, '0'));
        pZtSbRituToukeiSeibiRenTy.setZtyshrnaiyoukbn(
            Strings.padStart(pZtSbRituToukeiSeibiRenTy.getZtyshrnaiyoukbn(), 1, '0'));
        pZtSbRituToukeiSeibiRenTy.setZtyshrymd(
            Strings.padStart(pZtSbRituToukeiSeibiRenTy.getZtyshrymd(), 8, '0'));
        pZtSbRituToukeiSeibiRenTy.setZtysyuurouhunoukgjyoutaikbn(
            Strings.padStart(pZtSbRituToukeiSeibiRenTy.getZtysyuurouhunoukgjyoutaikbn(), 1, '0'));
        pZtSbRituToukeiSeibiRenTy.setZtysyuurouhunoujyoutaikbn(
            Strings.padStart(pZtSbRituToukeiSeibiRenTy.getZtysyuurouhunoujyoutaikbn(), 2, '0'));
        pZtSbRituToukeiSeibiRenTy.setZtysysnikoujiym(
            Strings.padStart(pZtSbRituToukeiSeibiRenTy.getZtysysnikoujiym(), 6, '0'));
        pZtSbRituToukeiSeibiRenTy.setZtysysnymd(
            Strings.padStart(pZtSbRituToukeiSeibiRenTy.getZtysysnymd(), 8, '0'));
        pZtSbRituToukeiSeibiRenTy.setZtysymtymd(
            Strings.padStart(pZtSbRituToukeiSeibiRenTy.getZtysymtymd(), 8, '0'));
        pZtSbRituToukeiSeibiRenTy.setZtyfktrsmtkahikbn(
            Strings.padStart(pZtSbRituToukeiSeibiRenTy.getZtyfktrsmtkahikbn(), 1, '0'));
        pZtSbRituToukeiSeibiRenTy.setZtysykikjgykbn(
            Strings.padStart(pZtSbRituToukeiSeibiRenTy.getZtysykikjgykbn(), 1, '0'));
        pZtSbRituToukeiSeibiRenTy.setZtysykmtssyukahikbn(
            Strings.padStart(pZtSbRituToukeiSeibiRenTy.getZtysykmtssyukahikbn(), 1, '0'));
        pZtSbRituToukeiSeibiRenTy.setZtyngerkahikbn(
            Strings.padStart(pZtSbRituToukeiSeibiRenTy.getZtyngerkahikbn(), 1, '0'));
        pZtSbRituToukeiSeibiRenTy.setZtysindanymd(
            Strings.padStart(pZtSbRituToukeiSeibiRenTy.getZtysindanymd(), 8, '0'));
        pZtSbRituToukeiSeibiRenTy.setZtyseiketuseiyoukahikbn(
            Strings.padStart(pZtSbRituToukeiSeibiRenTy.getZtyseiketuseiyoukahikbn(), 1, '0'));
        pZtSbRituToukeiSeibiRenTy.setZtydai2hhknnen(
            Strings.padStart(pZtSbRituToukeiSeibiRenTy.getZtydai2hhknnen(), 2, '0'));
        pZtSbRituToukeiSeibiRenTy.setZtydai2hhknnentysihyj(
            Strings.padStart(pZtSbRituToukeiSeibiRenTy.getZtydai2hhknnentysihyj(), 1, '0'));
        pZtSbRituToukeiSeibiRenTy.setZtytihougeninkbn(
            Strings.padStart(pZtSbRituToukeiSeibiRenTy.getZtytihougeninkbn(), 1, '0'));
        pZtSbRituToukeiSeibiRenTy.setZtytyuutohukatkhyj(
            Strings.padStart(pZtSbRituToukeiSeibiRenTy.getZtytyuutohukatkhyj(), 1, '0'));
        pZtSbRituToukeiSeibiRenTy.setZtytokuyakuno(
            Strings.padStart(pZtSbRituToukeiSeibiRenTy.getZtytokuyakuno(), 2, '0'));
        pZtSbRituToukeiSeibiRenTy.setZtynyykkahikbn(
            Strings.padStart(pZtSbRituToukeiSeibiRenTy.getZtynyykkahikbn(), 1, '0'));
        pZtSbRituToukeiSeibiRenTy.setZtyhhknnentysihyj(
            Strings.padStart(pZtSbRituToukeiSeibiRenTy.getZtyhhknnentysihyj(), 1, '0'));
        pZtSbRituToukeiSeibiRenTy.setZtybyoumeicd1(
            Strings.padStart(pZtSbRituToukeiSeibiRenTy.getZtybyoumeicd1(), 4, '0'));
        pZtSbRituToukeiSeibiRenTy.setZtybyoumeicd2(
            Strings.padStart(pZtSbRituToukeiSeibiRenTy.getZtybyoumeicd2(), 4, '0'));
        pZtSbRituToukeiSeibiRenTy.setZtyhushrkbn(
            Strings.padStart(pZtSbRituToukeiSeibiRenTy.getZtyhushrkbn(), 1, '0'));
        pZtSbRituToukeiSeibiRenTy.setZtyhushrym(
            Strings.padStart(pZtSbRituToukeiSeibiRenTy.getZtyhushrym(), 6, '0'));
        pZtSbRituToukeiSeibiRenTy.setZtybnktjisisttkarihyj(
            Strings.padStart(pZtSbRituToukeiSeibiRenTy.getZtybnktjisisttkarihyj(), 1, '0'));
        pZtSbRituToukeiSeibiRenTy.setZtybnktjitiktkarihyj(
            Strings.padStart(pZtSbRituToukeiSeibiRenTy.getZtybnktjitiktkarihyj(), 1, '0'));
        pZtSbRituToukeiSeibiRenTy.setZtybnkttnknkbn(
            Strings.padStart(pZtSbRituToukeiSeibiRenTy.getZtybnkttnknkbn(), 1, '0'));
        pZtSbRituToukeiSeibiRenTy.setZtyhokoukahikbn(
            Strings.padStart(pZtSbRituToukeiSeibiRenTy.getZtyhokoukahikbn(), 1, '0'));
        pZtSbRituToukeiSeibiRenTy.setZtymnsisiensindanjiyuu(
            Strings.padStart(pZtSbRituToukeiSeibiRenTy.getZtymnsisiensindanjiyuu(), 1, '0'));
        pZtSbRituToukeiSeibiRenTy.setZtyyoukigjyutigituymd(
            Strings.padStart(pZtSbRituToukeiSeibiRenTy.getZtyyoukigjyutigituymd(), 8, '0'));
        pZtSbRituToukeiSeibiRenTy.setZtyyoukigjyutigeninkbn(
            Strings.padStart(pZtSbRituToukeiSeibiRenTy.getZtyyoukigjyutigeninkbn(), 1, '0'));

    }
}
