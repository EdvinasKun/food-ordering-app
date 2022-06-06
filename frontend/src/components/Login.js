import React, { useState, useRef } from "react";
import { useNavigate } from "react-router-dom";
import Form from "react-validation/build/form";
import Input from "react-validation/build/input";
import CheckButton from "react-validation/build/button";

import { useForm } from "react-hook-form";
import AuthService from "../services/auth.service";
import "./Form.css";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faUnlockKeyhole } from "@fortawesome/free-solid-svg-icons";

export default function Login() {
  let navigate = useNavigate();
  const {
    register,
    handleSubmit,
    formState: { errors },
  } = useForm({ mode: "onSubmit", reValidateMode: "onSubmit" });
  const onSubmit = (data) => {
    AuthService.login(data.email, data.password)
    .then(() => {
      navigate("/profile");
      //window.location.reload();
    })
    

    // .then(() => {
    //     fetch(`http://localhost:8080/api/user/${data.email}`)
    //         .then(response => response.json())
    //         .then(data => {
    //             if (data.roles.some(role => role.name === "ROLE_ADMIN")) {
    //                 // navigate("/admin");
    //                 navigate("/users");
    //                 setRender(!render);
    //             } else {
    //                 navigate("/income");
    //                 setRender(!render);
    //             }
    //         });
    // })
    // .catch(() => setMessage("El. paštas arba slaptažodis yra neteisingas"));
  };
  const [passwordShown, setPasswordShown] = useState(false);
  const togglePassword = () => {
    // When the handler is invoked
    // chnage inverse the boolean state passwordShown
    setPasswordShown(!passwordShown);
  };

  return (
    <>
      <div className="login-dark">
        <form onSubmit={handleSubmit(onSubmit)}>
          {/* <h2 className="sr-only">Login Form</h2> */}
          <FontAwesomeIcon icon={faUnlockKeyhole} className="illustration" />
          <div className="form-group">
            <input
            {...register("email", { required: true })}
              className="form-control"
              //validating by email
              // type="email"
              name="email"
              placeholder="Email"
            />
          </div>
          <div className="form-group">
            <input
            {...register("password", { required: true })}
              className="form-control"
              type={passwordShown ? "text" : "password"}
              name="password"
              placeholder="Password"
            />
            <div style={{ paddingTop: 10 }}>
                          <input type="checkbox" onClick={togglePassword} />{" "}
                          Show password
                        </div>
          </div>
          <div className="form-group">
            <button
              className="btn btn-primary btn-block col-12 mb-3"
              type="submit"
            >
              Log In
            </button>
          </div>
          <a href="#" className="forgot">
            Forgot your email or password?
          </a>
        </form>
      </div>
    </>
  );
}
