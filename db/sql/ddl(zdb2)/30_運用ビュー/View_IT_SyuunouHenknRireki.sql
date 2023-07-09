CREATE VIEW IT_SyuunouHenknRireki AS SELECT
     kbnkey ,         /* 区分キー */
     syono ,         /* 証券番号 */
     denrenno ,         /* 伝票データ連番 */
     edano ,         /* 枝番号 */
     denkihyouymd ,         /* 伝票起票日 */
     shrymd ,         /* 支払日 */
     kanjyoukmkcd ,         /* 勘定科目コード */
     hnkngk ,         /* 返金額 */
     hnkngk$ ,         /* 返金額(通貨型) */
     shrriyuukbn ,         /* 支払理由区分 */
     bankcd ,         /* 銀行コード */
     sitencd ,         /* 支店コード */
     yokinkbn ,         /* 預金種目区分 */
     kouzano ,         /* 口座番号 */
     kzmeiginmkn ,         /* 口座名義人氏名（カナ） */
     creditcardno1 ,         /* クレジットカード番号１ */
     creditcardno2 ,         /* クレジットカード番号２ */
     creditcardno3 ,         /* クレジットカード番号３ */
     creditcardno4 ,         /* クレジットカード番号４ */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version ,         /* バージョン */
     creditkessaiyouno           /* クレジットカード決済用番号 */
FROM IT_SyuunouHenknRireki_Z;