package yuyu.app.hozen.khozen.khkeiyakusyoukai;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

/**
 * 契約内容照会 - ●保険料積立金内容 の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenHokenryouTmttInfoDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private BizDateY disptaisyound;

    public BizDateY getDisptaisyound() {
        return disptaisyound;
    }

    public void setDisptaisyound(BizDateY pDisptaisyound) {
        disptaisyound = pDisptaisyound;
    }


    private BizDate dispkouryokukaisiymd;

    public BizDate getDispkouryokukaisiymd() {
        return dispkouryokukaisiymd;
    }

    public void setDispkouryokukaisiymd(BizDate pDispkouryokukaisiymd) {
        dispkouryokukaisiymd = pDispkouryokukaisiymd;
    }


    private BizCurrency dispteiritutmttkngk;

    public BizCurrency getDispteiritutmttkngk() {
        return dispteiritutmttkngk;
    }

    public void setDispteiritutmttkngk(BizCurrency pDispteiritutmttkngk) {
        dispteiritutmttkngk = pDispteiritutmttkngk;
    }


    private BizNumber disptmttknhaneisisuu;

    public BizNumber getDisptmttknhaneisisuu() {
        return disptmttknhaneisisuu;
    }

    public void setDisptmttknhaneisisuu(BizNumber pDisptmttknhaneisisuu) {
        disptmttknhaneisisuu = pDisptmttknhaneisisuu;
    }


    private BizNumber dispsisuuupritu;

    public BizNumber getDispsisuuupritu() {
        return dispsisuuupritu;
    }

    public void setDispsisuuupritu(BizNumber pDispsisuuupritu) {
        dispsisuuupritu = pDispsisuuupritu;
    }


    private BizCurrency dispsisuurendoutmttkngk;

    public BizCurrency getDispsisuurendoutmttkngk() {
        return dispsisuurendoutmttkngk;
    }

    public void setDispsisuurendoutmttkngk(BizCurrency pDispsisuurendoutmttkngk) {
        dispsisuurendoutmttkngk = pDispsisuurendoutmttkngk;
    }

}
