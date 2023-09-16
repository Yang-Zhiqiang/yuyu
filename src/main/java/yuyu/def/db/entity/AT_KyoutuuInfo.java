package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.id.PKAT_KyoutuuInfo;
import yuyu.def.db.mapping.GenAT_KyoutuuInfo;
import yuyu.def.db.meta.GenQAT_KyoutuuInfo;
import yuyu.def.db.meta.QAT_KyoutuuInfo;

/**
 * 共通情報テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenAT_KyoutuuInfo} の JavaDoc を参照してください。
 * @see     GenAT_KyoutuuInfo
 * @see     PKAT_KyoutuuInfo
 * @see     QAT_KyoutuuInfo
 * @see     GenQAT_KyoutuuInfo
 */
@Entity
public class AT_KyoutuuInfo extends GenAT_KyoutuuInfo {

    // TODO 2014/03/18 T.Hoshino AT_KyoutuuInfo はテーブル設計変更が必要
    //
    // 共通情報テーブル は 機能ID(+連番) が主キーとなっているが、
    //        これを ロールコード(+連番) に変えなければならない。
    //
    // 「何故 機能ID が主キーになっているか」の理由だが、コレは古の JLoan 時代の名残りである。
    //
    // JLoan は当初「ロール」という権限基盤を持っていなかった。
    // JLoan の権限基盤は「ユーザーアカウント毎に、この人はこの機能を使って良い・この機能も使って良い」と
    // 「一人ひとりに使える機能のリストを個別に設定する」というモノで、「ユーザーアカウント数が増えると権限管理の
    // 人的コストが爆発的に跳ね上がる」という根本問題を抱えた前時代的権限基盤だった。
    //
    // 一方、共通情報は本来「この権限を持っているならばこのメッセージを表示」のように「権限毎にメッセージを登録」
    // したいのだが、JLoan の権限基盤ではこの「権限」に該当するものが「その人が使える機能のリスト」しか無かった。
    // 故に、機能ID が主キーとなり、ログインした人が利用可能な機能のリストと共通情報の機能IDをマッチングして
    // 「そのログインユーザーに見せるべき共通情報であるか」を判定していた。
    //
    // ここまで「機能ID が主キーである理由」を説明すればもう解ると思うが、
    // 今回のシステムには「ロール」という権限基盤が存在する。故に共通情報も本来の目論見通り
    // 「権限毎にメッセージを登録」するという業務基盤は出来上がっている訳だ。
    //
    // だから主キーを「ロールコード(+連番)」に変えなければならないのだ。

    private static final long serialVersionUID = 1L;

    public AT_KyoutuuInfo() {
    }

    public AT_KyoutuuInfo(String pKinouId, String pInfoSeqNo) {
        super(pKinouId, pInfoSeqNo);
    }

}
