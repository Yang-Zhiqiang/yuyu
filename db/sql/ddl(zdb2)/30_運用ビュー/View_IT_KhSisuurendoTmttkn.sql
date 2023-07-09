CREATE VIEW IT_KhSisuurendoTmttkn AS SELECT
     kbnkey ,         /* 区分キー */
     syono ,         /* 証券番号 */
     tmttkntaisyouym ,         /* 積立金対象年月 */
     renno ,         /* 連番 */
     tmttknkouryokukaisiymd ,         /* 積立金効力開始日 */
     teiritutmttkngk ,         /* 定率積立金額 */
     teiritutmttkngk$ ,         /* 定率積立金額(通貨型) */
     sisuurendoutmttkngk ,         /* 指数連動積立金額 */
     sisuurendoutmttkngk$ ,         /* 指数連動積立金額(通貨型) */
     sisuuupritu ,         /* 指数上昇率 */
     tmttknzoukaritu ,         /* 積立金増加率 */
     tmttknhaneitmmshanteiymd ,         /* 積立金反映時積増判定日 */
     tmttknhaneisisuu ,         /* 積立金反映時指数 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version ,         /* バージョン */
     itenmaeteiritutmttkngk ,         /* 移転前定率積立金額 */
     itenmaeteiritutmttkngk$ ,         /* 移転前定率積立金額(通貨型) */
     itenmaesisuurendoutmttkngk ,         /* 移転前指数連動積立金額 */
     itenmaesisuurendoutmttkngk$           /* 移転前指数連動積立金額(通貨型) */
FROM IT_KhSisuurendoTmttkn_Z;