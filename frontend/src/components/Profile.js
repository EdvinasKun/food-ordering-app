import React from "react";
import AuthService from "../services/auth.service";
import establishmentService from "../services/establishmentService";

import Form from 'react-bootstrap/Form'

import { useNavigate } from 'react-router-dom';
import { useForm } from "react-hook-form";
export default function Profile () {

  const currentUser = AuthService.getCurrentUser();

  const establishtment = establishmentService.getEstablihsments();

  const onSubmit = (data) => {
    establishmentService.insertEstablihsment(data.name, data.code, data.address)
      .then(() => {
        
        //window.location.reload();
      })
    };
      const { register, handleSubmit, watch, formState: { errors } } = useForm({ mode: 'onSubmit', reValidateMode: 'onSubmit' });
      const navigate = useNavigate();

    return (
      <div className="container">
        <header className="jumbotron">
          <h3>
            <strong>{currentUser.username}</strong> Profile
          </h3>
        </header>
        <p>
          <strong>Id:</strong> {currentUser.id}
        </p>
        <p>
          <strong>text:</strong> {currentUser.text}
        </p>
        <strong>Authorities:</strong>
        <ul>
          {currentUser.roles &&
            currentUser.roles.map((role, index) => <li key={index}>{role}</li>)}
        </ul>



        <div>
          <div>
            <form onSubmit={handleSubmit(onSubmit)}>
              {/* <h2 className="sr-only">Login Form</h2> */}
              
              <div className="form-group">
                <input
                  {...register("name", { required: true })}
                  className="form-control"
                  //validating by email
                  // type="email"
                  name="email"
                  placeholder="Email"
                />
              </div>
              <div className="form-group">
                <input
                  {...register("code", { required: true })}
                  className="form-control"
                  //validating by email
                  // type="email"
                  name="email"
                  placeholder="Email"
                />
              </div>
              <div className="form-group">
                <input
                  {...register("address", { required: true })}
                  className="form-control"
                  //validating by email
                  // type="email"
                  name="email"
                  placeholder="Email"
                />
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
          <header className="jumbotron">
            <h3>
              <ul>
                {establishtment.establishmentName &&
                  establishtment.establishmentName.map((name, index) => <li key={index}>{name}</li>)}
              </ul>
            </h3>
          </header>
        </div>




      </div>
    );
  };
