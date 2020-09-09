package model

import java.io.Externalizable
import java.io.IOException
import java.io.ObjectInput
import java.io.ObjectOutput

abstract class Vehicle(registrationNo: String, color: String) : Externalizable {
    /**
     * @param registrationNo
     * the registrationNo to set
     */
    private var registrationNo: String? = null

    /**
     * @param color
     * the color to set
     */
    private var color: String? = null

    init {
        this.registrationNo = registrationNo
        this.color = color
    }

    override fun toString(): String {
        return "[registrationNo=$registrationNo, color=$color]"
    }

    @Throws(IOException::class)
    override fun writeExternal(out: ObjectOutput) {
        out.writeObject(registrationNo)
        out.writeObject(color)
    }

    @Throws(IOException::class, ClassNotFoundException::class)
    override fun readExternal(`in`: ObjectInput) {
        registrationNo = `in`.readObject() as String
        color = `in`.readObject() as String
    }
}
