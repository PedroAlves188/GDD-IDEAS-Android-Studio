package com.example.gdd_ideas.database.daos

import androidx.room.EntityDeleteOrUpdateAdapter
import androidx.room.EntityInsertAdapter
import androidx.room.RoomDatabase
import androidx.room.util.getColumnIndexOrThrow
import androidx.room.util.performBlocking
import androidx.sqlite.SQLiteStatement
import com.example.gdd_ideas.database.entities.User
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
public class UserDao_Impl(
  __db: RoomDatabase,
) : UserDao {
  private val __db: RoomDatabase

  private val __insertAdapterOfUser: EntityInsertAdapter<User>

  private val __updateAdapterOfUser: EntityDeleteOrUpdateAdapter<User>
  init {
    this.__db = __db
    this.__insertAdapterOfUser = object : EntityInsertAdapter<User>() {
      protected override fun createQuery(): String =
          "INSERT OR ABORT INTO `tb_user` (`id`,`name`,`email`,`password`) VALUES (?,?,?,?)"

      protected override fun bind(statement: SQLiteStatement, entity: User) {
        statement.bindText(1, entity.id)
        statement.bindText(2, entity.name)
        statement.bindText(3, entity.email)
        statement.bindText(4, entity.password)
      }
    }
    this.__updateAdapterOfUser = object : EntityDeleteOrUpdateAdapter<User>() {
      protected override fun createQuery(): String =
          "UPDATE OR ABORT `tb_user` SET `id` = ?,`name` = ?,`email` = ?,`password` = ? WHERE `id` = ?"

      protected override fun bind(statement: SQLiteStatement, entity: User) {
        statement.bindText(1, entity.id)
        statement.bindText(2, entity.name)
        statement.bindText(3, entity.email)
        statement.bindText(4, entity.password)
        statement.bindText(5, entity.id)
      }
    }
  }

  public override fun save(user: User): Long = performBlocking(__db, false, true) { _connection ->
    val _result: Long = __insertAdapterOfUser.insertAndReturnId(_connection, user)
    _result
  }

  public override fun update(user: User): Int = performBlocking(__db, false, true) { _connection ->
    var _result: Int = 0
    _result += __updateAdapterOfUser.handle(_connection, user)
    _result
  }

  public override fun checkAllTable(): List<User> {
    val _sql: String = "SELECT * FROM tb_user"
    return performBlocking(__db, true, false) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        val _columnIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _columnIndexOfName: Int = getColumnIndexOrThrow(_stmt, "name")
        val _columnIndexOfEmail: Int = getColumnIndexOrThrow(_stmt, "email")
        val _columnIndexOfPassword: Int = getColumnIndexOrThrow(_stmt, "password")
        val _result: MutableList<User> = mutableListOf()
        while (_stmt.step()) {
          val _item: User
          val _tmpId: String
          _tmpId = _stmt.getText(_columnIndexOfId)
          val _tmpName: String
          _tmpName = _stmt.getText(_columnIndexOfName)
          val _tmpEmail: String
          _tmpEmail = _stmt.getText(_columnIndexOfEmail)
          val _tmpPassword: String
          _tmpPassword = _stmt.getText(_columnIndexOfPassword)
          _item = User(_tmpId,_tmpName,_tmpEmail,_tmpPassword)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override fun checkLogin(userId: String, passId: String): Boolean {
    val _sql: String =
        "SELECT EXISTS (SELECT * FROM tb_user WHERE (name = ? OR email = ?) AND password = ?)"
    return performBlocking(__db, true, false) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindText(_argIndex, userId)
        _argIndex = 2
        _stmt.bindText(_argIndex, userId)
        _argIndex = 3
        _stmt.bindText(_argIndex, passId)
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

  public override fun checkExistEmail(email: String): Boolean {
    val _sql: String = "SELECT EXISTS(SELECT * FROM tb_user WHERE email = ?)"
    return performBlocking(__db, true, false) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindText(_argIndex, email)
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

  public companion object {
    public fun getRequiredConverters(): List<KClass<*>> = emptyList()
  }
}
