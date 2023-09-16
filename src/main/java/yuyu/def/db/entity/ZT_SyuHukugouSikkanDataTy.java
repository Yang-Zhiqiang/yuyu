package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_SyuHukugouSikkanDataTy;
import yuyu.def.db.mapping.GenZT_SyuHukugouSikkanDataTy;
import yuyu.def.db.meta.GenQZT_SyuHukugouSikkanDataTy;
import yuyu.def.db.meta.QZT_SyuHukugouSikkanDataTy;

/**
 * 普保Ⅱ主契約複合疾患データテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SyuHukugouSikkanDataTy} の JavaDoc を参照してください。
 * @see     GenZT_SyuHukugouSikkanDataTy
 * @see     PKZT_SyuHukugouSikkanDataTy
 * @see     QZT_SyuHukugouSikkanDataTy
 * @see     GenQZT_SyuHukugouSikkanDataTy
 */
@Entity
public class ZT_SyuHukugouSikkanDataTy extends GenZT_SyuHukugouSikkanDataTy {

    private static final long serialVersionUID = 1L;

    public ZT_SyuHukugouSikkanDataTy() {
    }

    public ZT_SyuHukugouSikkanDataTy(
        String pZtyijitoukeidaihyousyurui,
        String pZtykeiyakunendo,
        String pZtyhknnendo,
        String pZtyhhknseikbn,
        String pZtykykage,
        String pZtytoutatunenrei,
        String pZtyatukaibetu,
        String pZtysinsahouhou,
        String pZtyketteikekkakbn,
        String pZtysibousrank,
        String pZtyjissituhosyousrank,
        String pZtysirajikykkbn,
        String pZtyhrkhuhukbn,
        String pZtyhknsyurui2keta,
        String pZtydaisiincd,
        String pZtytyuusiincd,
        String pZtysyousiincd,
        String pZtynenreihousikikbn,
        String pZtysykgycd,
        String pZtytodouhukencd,
        String pZtybotaisisyaeigyouhonbu,
        String pZtysisyaeigyoubu,
        String pZtyaatukaisosikicd,
        String pZtynensyuukbn,
        String pZtyhanbaikeirokbn,
        String pZtyoyadairitencd,
        String pZtytratkidrtencd,
        String pZtybsudirtnatkikeitaikbn,
        String pZtykyktuuka,
        String pZtyhrktuuka,
        String pZtyhknsyukigou,
        String pZtysyksbyensitihsyutyhkumu,
        String pZtyjyudkaigomehrtkhkumu,
        String pZtyijitoukeizennoukbn,
        String pZtydai1hknkkn,
        String pZtyijitoukeitikshrtkykkbn
    ) {
        super(
            pZtyijitoukeidaihyousyurui,
            pZtykeiyakunendo,
            pZtyhknnendo,
            pZtyhhknseikbn,
            pZtykykage,
            pZtytoutatunenrei,
            pZtyatukaibetu,
            pZtysinsahouhou,
            pZtyketteikekkakbn,
            pZtysibousrank,
            pZtyjissituhosyousrank,
            pZtysirajikykkbn,
            pZtyhrkhuhukbn,
            pZtyhknsyurui2keta,
            pZtydaisiincd,
            pZtytyuusiincd,
            pZtysyousiincd,
            pZtynenreihousikikbn,
            pZtysykgycd,
            pZtytodouhukencd,
            pZtybotaisisyaeigyouhonbu,
            pZtysisyaeigyoubu,
            pZtyaatukaisosikicd,
            pZtynensyuukbn,
            pZtyhanbaikeirokbn,
            pZtyoyadairitencd,
            pZtytratkidrtencd,
            pZtybsudirtnatkikeitaikbn,
            pZtykyktuuka,
            pZtyhrktuuka,
            pZtyhknsyukigou,
            pZtysyksbyensitihsyutyhkumu,
            pZtyjyudkaigomehrtkhkumu,
            pZtyijitoukeizennoukbn,
            pZtydai1hknkkn,
            pZtyijitoukeitikshrtkykkbn
        );
    }

}
