package com.example.gdd_ideas.database.daos

import androidx.room.EntityDeleteOrUpdateAdapter
import androidx.room.EntityInsertAdapter
import androidx.room.RoomDatabase
import androidx.room.util.getColumnIndexOrThrow
import androidx.room.util.getTotalChangedRows
import androidx.room.util.performBlocking
import androidx.sqlite.SQLiteStatement
import com.example.gdd_ideas.database.entities.Proj
import javax.`annotation`.processing.Generated
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlin.collections.mutableListOf
import kotlin.reflect.KClass

@Generated(value = ["androidx.room.RoomProcessor"])
@Suppress(names = ["UNCHECKED_CAST", "DEPRECATION", "REDUNDANT_PROJECTION", "REMOVAL"])
public class ProjDao_Impl(
  __db: RoomDatabase,
) : ProjDao {
  private val __db: RoomDatabase

  private val __insertAdapterOfProj: EntityInsertAdapter<Proj>

  private val __updateAdapterOfProj: EntityDeleteOrUpdateAdapter<Proj>
  init {
    this.__db = __db
    this.__insertAdapterOfProj = object : EntityInsertAdapter<Proj>() {
      protected override fun createQuery(): String =
          "INSERT OR ABORT INTO `tb_proj` (`idProj`,`projName`,`projDesc`,`fkUser`) VALUES (?,?,?,?)"

      protected override fun bind(statement: SQLiteStatement, entity: Proj) {
        statement.bindText(1, entity.idProj)
        statement.bindText(2, entity.projName)
        statement.bindText(3, entity.projDesc)
        statement.bindText(4, entity.fkUser)
      }
    }
    this.__updateAdapterOfProj = object : EntityDeleteOrUpdateAdapter<Proj>() {
      protected override fun createQuery(): String =
          "UPDATE OR ABORT `tb_proj` SET `idProj` = ?,`projName` = ?,`projDesc` = ?,`fkUser` = ? WHERE `idProj` = ?"

      protected override fun bind(statement: SQLiteStatement, entity: Proj) {
        statement.bindText(1, entity.idProj)
        statement.bindText(2, entity.projName)
        statement.bindText(3, entity.projDesc)
        statement.bindText(4, entity.fkUser)
        statement.bindText(5, entity.idProj)
      }
    }
  }

  public override fun saveProj(proj: Proj): Long = performBlocking(__db, false, true) {
      _connection ->
    val _result: Long = __insertAdapterOfProj.insertAndReturnId(_connection, proj)
    _result
  }

  public override fun updateProj(proj: Proj): Int = performBlocking(__db, false, true) {
      _connection ->
    var _result: Int = 0
    _result += __updateAdapterOfProj.handle(_connection, proj)
    _result
  }

  public override fun checkAllTable(): List<Proj> {
    val _sql: String = "SELECT * FROM tb_proj"
    return performBlocking(__db, true, false) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        val _columnIndexOfIdProj: Int = getColumnIndexOrThrow(_stmt, "idProj")
        val _columnIndexOfProjName: Int = getColumnIndexOrThrow(_stmt, "projName")
        val _columnIndexOfProjDesc: Int = getColumnIndexOrThrow(_stmt, "projDesc")
        val _columnIndexOfFkUser: Int = getColumnIndexOrThrow(_stmt, "fkUser")
        val _result: MutableList<Proj> = mutableListOf()
        while (_stmt.step()) {
          val _item: Proj
          val _tmpIdProj: String
          _tmpIdProj = _stmt.getText(_columnIndexOfIdProj)
          val _tmpProjName: String
          _tmpProjName = _stmt.getText(_columnIndexOfProjName)
          val _tmpProjDesc: String
          _tmpProjDesc = _stmt.getText(_columnIndexOfProjDesc)
          val _tmpFkUser: String
          _tmpFkUser = _stmt.getText(_columnIndexOfFkUser)
          _item = Proj(_tmpIdProj,_tmpProjName,_tmpProjDesc,_tmpFkUser)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override fun checkCurUser(fkUser: String): Boolean {
    val _sql: String = "SELECT EXISTS(SELECT * FROM tb_proj WHERE fkUser = ?)"
    return performBlocking(__db, true, false) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindText(_argIndex, fkUser)
        val _result: Boolean
        if (_stmt.step()) {
          val _tmp: Int
          _tmp = _stmt.getLong(0).toInt()
          _result = _tmp != 0
        } else {
          _result = false
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override fun deleteTable(): Int {
    val _sql: String = "DELETE FROM tb_proj"
    return performBlocking(__db, false, true) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        _stmt.step()
        getTotalChangedRows(_connection)
      } finally {
        _stmt.close()
      }
    }
  }

  public companion object {
    public fun getRequiredConverters(): List<KClass<*>> = emptyList()
  }
}
