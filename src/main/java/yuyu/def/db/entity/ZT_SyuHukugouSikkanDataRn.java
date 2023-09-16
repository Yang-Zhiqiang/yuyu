package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_SyuHukugouSikkanDataRn;
import yuyu.def.db.mapping.GenZT_SyuHukugouSikkanDataRn;
import yuyu.def.db.meta.GenQZT_SyuHukugouSikkanDataRn;
import yuyu.def.db.meta.QZT_SyuHukugouSikkanDataRn;

/**
 * 普保Ⅱ主契約複合疾患データテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SyuHukugouSikkanDataRn} の JavaDoc を参照してください。
 * @see     GenZT_SyuHukugouSikkanDataRn
 * @see     PKZT_SyuHukugouSikkanDataRn
 * @see     QZT_SyuHukugouSikkanDataRn
 * @see     GenQZT_SyuHukugouSikkanDataRn
 */
@Entity
public class ZT_SyuHukugouSikkanDataRn extends GenZT_SyuHukugouSikkanDataRn {

    private static final long serialVersionUID = 1L;

    public ZT_SyuHukugouSikkanDataRn() {
    }

    public ZT_SyuHukugouSikkanDataRn(
        String pZrnijitoukeidaihyousyurui,
        String pZrnkeiyakunendo,
        String pZrnhknnendo,
        String pZrnhhknseikbn,
        String pZrnkykage,
        String pZrntoutatunenrei,
        String pZrnatukaibetu,
        String pZrnsinsahouhou,
        String pZrnketteikekkakbn,
        String pZrnsibousrank,
        String pZrnjissituhosyousrank,
        String pZrnsirajikykkbn,
        String pZrnhrkhuhukbn,
        String pZrnhknsyurui2keta,
        String pZrndaisiincd,
        String pZrntyuusiincd,
        String pZrnsyousiincd,
        String pZrnnenreihousikikbn,
        String pZrnsykgycd,
        String pZrntodouhukencd,
        String pZrnbotaisisyaeigyouhonbu,
        String pZrnsisyaeigyoubu,
        String pZrnaatukaisosikicd,
        String pZrnnensyuukbn,
        String pZrnhanbaikeirokbn,
        String pZrnoyadairitencd,
        String pZrntratkidrtencd,
        String pZrnbsudirtnatkikeitaikbn,
        String pZrnkyktuuka,
        String pZrnhrktuuka,
        String pZrnhknsyukigou,
        String pZrnsyksbyensitihsyutyhkumu,
        String pZrnjyudkaigomehrtkhkumu,
        String pZrnijitoukeizennoukbn,
        String pZrndai1hknkkn,
        String pZrnijitoukeitikshrtkykkbn
    ) {
        super(
            pZrnijitoukeidaihyousyurui,
            pZrnkeiyakunendo,
            pZrnhknnendo,
            pZrnhhknseikbn,
            pZrnkykage,
            pZrntoutatunenrei,
            pZrnatukaibetu,
            pZrnsinsahouhou,
            pZrnketteikekkakbn,
            pZrnsibousrank,
            pZrnjissituhosyousrank,
            pZrnsirajikykkbn,
            pZrnhrkhuhukbn,
            pZrnhknsyurui2keta,
            pZrndaisiincd,
            pZrntyuusiincd,
            pZrnsyousiincd,
            pZrnnenreihousikikbn,
            pZrnsykgycd,
            pZrntodouhukencd,
            pZrnbotaisisyaeigyouhonbu,
            pZrnsisyaeigyoubu,
            pZrnaatukaisosikicd,
            pZrnnensyuukbn,
            pZrnhanbaikeirokbn,
            pZrnoyadairitencd,
            pZrntratkidrtencd,
            pZrnbsudirtnatkikeitaikbn,
            pZrnkyktuuka,
            pZrnhrktuuka,
            pZrnhknsyukigou,
            pZrnsyksbyensitihsyutyhkumu,
            pZrnjyudkaigomehrtkhkumu,
            pZrnijitoukeizennoukbn,
            pZrndai1hknkkn,
            pZrnijitoukeitikshrtkykkbn
        );
    }

}
