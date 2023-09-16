package yuyu.def.db.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import jp.co.slcs.swak.batch.engine.BatchDef;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import yuyu.def.base.configuration.YuyuBaseConfig;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.db.id.PKAM_Batch;
import yuyu.def.db.mapping.GenAM_Batch;
import yuyu.def.db.meta.GenQAM_Batch;
import yuyu.def.db.meta.QAM_Batch;

/**
 * バッチマスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenAM_Batch} の JavaDoc を参照してください。
 * @see     GenAM_Batch
 * @see     PKAM_Batch
 * @see     QAM_Batch
 * @see     GenQAM_Batch
 */
@Entity
public class AM_Batch extends GenAM_Batch implements BatchDef {

    private static final long serialVersionUID = 1L;

    public AM_Batch() {
    }

    public AM_Batch(String pKinouId) {
        super(pKinouId);
    }

    private AS_Kinou aS_Kinou;

    @LazyToOne(LazyToOneOption.FALSE)
    @ManyToOne (optional = true)
    @JoinColumn(name = AM_Batch.KINOUID, referencedColumnName = AS_Kinou.KINOUID, insertable = false, updatable = false)
    public AS_Kinou getKinou() {
        return aS_Kinou;
    }

    void setKinou(AS_Kinou pAS_Kinou) {
        aS_Kinou = pAS_Kinou;
    }

    @Override
    @Transient
    public String getBatchId() {
        return getKinouId();
    }

    @Override
    @Transient
    public String getClassName() {
        return getBatchClass();
    }

    @Override
    @Transient
    public String getMethodName() {
        return null;
    }

    @Override
    @Transient
    public boolean isMultiplex() {
        return getTajuukidouKahiKbn().eq(C_KahiKbn.KA);
    }

    //
    //  @Override
    //  @Transient
    //  public String getParamBeanClass() {
    //      String paramBeanClass = super.getParamBeanClass();
    //      if(Strings.isNullOrEmpty(paramBeanClass)){
    //          return YuyuBaseConfig.getInstance().getBatchParamBean();
    //      }
    //      return paramBeanClass;
    //  }
    // ↑ 2015/02/06 T.Hoshino 削除
    //    このコードは、エンティティーの getter をオーバーライドして
    //    「DB内の設定値が null(または 空文字列) だったら、デフォルトParamBean クラス名を返す」
    //    というコードなのだが、この方法で実装してしまうと
    //    「ここで得た デフォルトParamBeanクラス名 を DBに書き戻してしまう（UPDATE AM_Batch が発行される）」
    //    ことが判明した。
    //    おそらくJPAコンテナはトランザクション終了時、「DBから読んでPersistenceContextに記憶した値」と
    //    「ビジネスロジックを通ってきた後のEntityの値（Override した getter もビジネスロジックの一部とみなされる）」の
    //    差分比較を行い、「（Overrideしたことにより）差が出る」ので「ここの（Overrideした）getter の返す値 を set して UPDATE文 を発行」するのだと思われる。
    //    よって Entity の getter メソッドを Override するのは、ここでは望ましくない。
    //    @see #getDefaultParamBeanClass()

    @Override
    @Transient
    public String getDefaultParamBeanClass() {
        // 上の「getParamBeanClass() の Override を削除」に伴う、追加メソッド。
        // この getter はエンティティーのプロパティー（DBフィールド）ではなく、
        // swakバッチ基盤の {@link BatchDef#getDefaultParamBeanClass()} の実装となる。
        // よって @Transient (永続化対象外) である。 2015/02/09 T.Hoshino
        return YuyuBaseConfig.getInstance().getBatchParamBean();
    }
}
