CREATE VIEW HT_SkSyuunouKekkaData AS SELECT
     ansyuusyskbn ,         /* 案内収納用システム区分 */
     syoriYmd ,         /* 処理年月日 */
     mosno ,         /* 申込番号 */
     jyuutouym ,         /* 充当年月 */
     jyutoukaisuuy ,         /* 充当回数（年） */
     jyutoukaisuum ,         /* 充当回数（月） */
     rsgaku ,         /* 領収金額 */
     rsgaku$ ,         /* 領収金額(通貨型) */
     hurikaeymd ,         /* 振替日 */
     syuudaikocd ,         /* 収納代行社コード */
     bankcd ,         /* 銀行コード */
     sitencd ,         /* 支店コード */
     yokinkbn ,         /* 預金種目区分 */
     kouzano ,         /* 口座番号 */
     kzmeiginmkn ,         /* 口座名義人氏名（カナ） */
     hurihunokbn ,         /* 振替不能理由区分 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM HT_SkSyuunouKekkaData_Z;